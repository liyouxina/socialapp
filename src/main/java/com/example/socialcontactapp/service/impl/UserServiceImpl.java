package com.example.socialcontactapp.service.impl;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.example.socialcontactapp.dao.UserDao;
import com.example.socialcontactapp.dao.UserdetailsDao;
import com.example.socialcontactapp.dao.WalletDao;
import com.example.socialcontactapp.entity.User;
import com.example.socialcontactapp.entity.Userdetails;
import com.example.socialcontactapp.entity.Wallet;
import com.example.socialcontactapp.service.UserService;
import com.example.socialcontactapp.utils.Code;
import com.example.socialcontactapp.utils.JWTUtil;
import com.example.socialcontactapp.utils.R;
import com.example.socialcontactapp.utils.message.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.example.socialcontactapp.utils.RedisConstant.VERIFYCODE;
import static com.example.socialcontactapp.utils.StringConstant.USERNAMEPREFIX;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2022-06-16 08:11:57
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    @Resource
    private UserdetailsDao userdetailsDao;
    @Resource
    private WalletDao walletDao;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public R loginByTel(String tel) {
        User user = this.userDao.queryByTel(tel);
        if (user == null)
            return R.error().data("msg", "用户未注册");
        //这里要将验证码数据存于redis
        return getCode(tel);
    }

    @Override
    public R getCode(String tel) {
        String code = Code.createVerifyCode();
        Boolean b = redisTemplate.opsForValue().setIfAbsent(VERIFYCODE + tel, code, 5, TimeUnit.MINUTES);
        if (!b) {
            return R.error().data("msg", "请勿在5分钟内重复获取验证码");
        }
        try {
            MessageSender.sendMessage(code, tel);
            return R.ok().data("verify", code);
        } catch (Exception e) {
            return R.error().data("msg", "发送短信出错");
        }
    }

    @Override
    public R loginByTel(String tel, String code) {
        if (verifyCode(tel, code)) {
            String token = getToken(tel);
            System.out.println(token);
            if (token == null)
                return R.error().data("msg", "非法操作");
            else
                return R.ok().data("token", token).data("msg", "登陆成功");
        }
        return R.error().data("msg", "验证码错误");
    }

    private String getToken(String tel) {
        User user = this.userDao.queryByTel(tel);
        if (user == null)
            return null;
        Map<String, String> payLoad = new HashMap<>();
        payLoad.put("id", user.getId().toString());
        payLoad.put("name", user.getName());
        String token = JWTUtil.getToken(payLoad);
        return token;
    }


    @Override
    public R loginByPassword(String password, String tel) {
        User user = this.userDao.queryByTel(tel);
        if (StrUtil.isBlank(user.getTel()))
            return R.error().data("msg", "该用户尚未注册");
        if (user.getPassword().equals(password)) {
            String token = getToken(tel);
            return R.ok().data("token", token).data("msg", "登陆成功");
        }
        return R.error().data("msg", "密码错误");
    }

    @Override
    public R register(String tel, String invitationCode, String password, String code) {
        User user1 = userDao.queryByTel(tel);
        if (user1 == null) {
            if (!verifyCode(tel, code))
                return R.error().data("msg", "验证码错误");
            User user = new User();
            Long userId = Code.createUserId();
            user.setId(userId).setName(USERNAMEPREFIX + userId).setTel(tel).setPassword(password);
            Long id = userdetailsDao.queryByinvitationCode(invitationCode);
            if (id != null)
                user.setInviteeId(id);
            userDao.insert(user);
            userdetailsDao.insert(new Userdetails().setUserid(userId).setInvitationcode(RandomUtil.randomString(8)));
            walletDao.insert(new Wallet().setRecharge(0f).setReward(0f).setUserid(userId));
            return R.ok().data("msg", "注册成功");
        }
        return R.error().data("msg", "该用户已经注册");
    }

    public boolean verifyCode(String tel, String code) {
        String s = redisTemplate.opsForValue().get(VERIFYCODE + tel);
        if (StrUtil.isBlank(s) || !s.equals(code))
            return false;
        return true;
    }
}