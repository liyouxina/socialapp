package com.example.socialcontactapp.utils;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTPayload;
import cn.hutool.jwt.JWTUtil;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Thread.sleep;

/**
 * @question
 * @Author xiyuan
 * @Date 2022/6/16 9:01
 * @Version 1.0
 */
public class Code {
    public static String createVerifyCode() {
        return RandomUtil.randomNumbers(6);
    }

    public static Long createUserId() {
        return Long.valueOf(RandomUtil.randomNumbers(8));
    }


}
