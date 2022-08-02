package com.example.socialcontactapp.controller;

import com.example.socialcontactapp.utils.JWTUtil;
import com.example.socialcontactapp.utils.R;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("wxpay")
public class WxPayController {

    @RequestMapping("pay")
    public R pay(String token, String goods) {
        Long userId = JWTUtil.getUserId(token);
        return R.ok();
    }
}
