package com.example.socialcontactapp.service.impl;

import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.util.SerializeUtil;
import com.example.socialcontactapp.dao.DynamicmessageDao;
import com.example.socialcontactapp.entity.Dynamicmessage;
import com.example.socialcontactapp.service.DynamicmessageService;
import com.example.socialcontactapp.utils.R;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static com.example.socialcontactapp.utils.JWTUtil.getUserId;

/**
 * (Dynamicmessage)表服务实现类
 *
 * @author makejava
 * @since 2022-06-16 08:11:57
 */
@Service
public class DynamicmessageServiceImpl implements DynamicmessageService {
    @Resource
    private DynamicmessageDao dynamicmessageDao;

    /**
     * 修改数据
     *
     * @param dynamicmessage 实例对象
     * @return 实例对象
     */
    @Override
    public R update(Dynamicmessage dynamicmessage, String token) {
        Long userId = getUserId(token);
        if (userId == null)
            return R.error().data("msg", "用户登陆过期");
        dynamicmessage.setUserid(userId);
        Dynamicmessage d = this.dynamicmessageDao.queryById(dynamicmessage.getMessageid());
        Long userid = d.getUserid();
        if (!userId.equals(userid))
            return R.error().data("msg", "越权修改");
        this.dynamicmessageDao.update(dynamicmessage);
        return R.ok().data("msg", "修改成功");
    }


    /**
     * 通过主键删除数据
     *
     * @param messageid 主键
     * @return 是否成功
     */
    @Override
    public R deleteById(String token, Integer messageid) {
        Long userId = getUserId(token);
        if (userId == null)
            return R.error().data("msg", "验证已过期");
        if (this.dynamicmessageDao.deleteById(messageid, userId) > 0)
            return R.ok().data("msg", "删除成功");
        return R.error().data("msg", "删除失败");
    }

    @Override
    public R publishDynamics(String token, String label, String address, Integer nums, String topic, String pictures, String content) {
        Long userId = getUserId(token);
        if (userId == null)
            return R.error().data("msg", "验证已过期");
        Dynamicmessage dynamicmessage = new Dynamicmessage();
        dynamicmessage.setAddress(address).setUserid(Long.valueOf(userId))
                .setLabel(label).setTopic(topic)
                .setNums(nums).setPictures(pictures)
                .setContent(content).setDatatime(LocalDateTimeUtil.now());
        this.dynamicmessageDao.insert(dynamicmessage);
        return R.ok().data("msg", "发布成功");
    }

    @Override
    public R queryByUserId(String token, int offset) {
        Long userId = getUserId(token);
        if (userId == null)
            return R.error().data("msg", "验证已过期");
        List<Dynamicmessage> list = this.dynamicmessageDao.queryByUserId(userId, offset);
        for (Dynamicmessage dynamicmessage : list) {
            String pictures = dynamicmessage.getPictures();
//            List<String> deserialize = (List<String>) SerializeUtil.deserialize(pictures.getBytes());
        }
        return R.ok().data("msg", list);
    }
    @Override
    public R addLove(String token, int messageId){
        Long userId = getUserId(token);
        if (userId == null)
            return R.error().data("msg", "验证已过期");
        if(this.dynamicmessageDao.addLove(messageId)<=0)
            return R.error().data("msg","失败");
        return R.ok().data("msg","成功");
    }

}