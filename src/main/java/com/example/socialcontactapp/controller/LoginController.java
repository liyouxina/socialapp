package com.example.socialcontactapp.controller;

import cn.hutool.core.util.StrUtil;
import com.example.socialcontactapp.service.UserService;
import com.example.socialcontactapp.utils.R;
import com.example.socialcontactapp.utils.RegexUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2022-06-16 08:11:57
 */
@CrossOrigin
@RestController
@RequestMapping("user")
public class LoginController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;


    /**
     * 电话号码登陆
     *
     * @param tel
     * @return
     */
    @GetMapping("loginByTel")
    public R loginByTel(String tel) {
        if (StrUtil.isBlank(tel))
            return R.error().data("msg", "电话输入为空");
        if (RegexUtils.isPhoneInvalid(tel)) {
            return R.error().data("msg", "手机号码格式有误");
        }
        return this.userService.loginByTel(tel);
    }

    @GetMapping("getCode")
    public R getCode(String tel) {
        if (StrUtil.isBlank(tel))
            return R.error().data("msg", "电话输入为空");
        if (RegexUtils.isPhoneInvalid(tel)) {
            return R.error().data("msg", "手机号码格式有误");
        }
        return this.userService.getCode(tel);
    }

    /**
     * 验证码验证
     *
     * @param tel
     * @param code
     * @return
     */
    @GetMapping("verifyCode")
    public R verifyCode(String tel, String code) {
        if (StrUtil.isBlank(tel) || StrUtil.isBlank(code))
            return R.error().data("msg", "电话或者验证码输入为空");
        if (RegexUtils.isPhoneInvalid(tel)) {
            return R.error().data("msg", "手机号码格式有误");
        }
        return this.userService.loginByTel(tel, code);
    }

    @GetMapping("loginByPassword")
    public R loginByPassword(String password, String tel) {
        if (StrUtil.isBlank(tel) || StrUtil.isBlank(password))
            return R.error().data("msg", "电话或者密码输入为空");
        if (RegexUtils.isPhoneInvalid(tel)) {
            return R.error().data("msg", "手机号码格式有误");
        }
        return userService.loginByPassword(password, tel);
    }

    @PostMapping("register")
    public R register(String tel, String invitationCode, String password, String code) {
        if (StrUtil.isBlank(tel)){
            return R.error().data("msg", "电话号码为空");
        }
        if (StrUtil.isBlank(password)) {
            return R.error().data("msg", "密码为空");
        }
        if (StrUtil.isBlank(code)) {
            return R.error().data("msg", "验证码为空");
        }
        if (RegexUtils.isPhoneInvalid(tel)) {
            return R.error().data("msg", "手机号码格式有误");
        }
        return userService.register(tel, invitationCode, password, code);
    }
}