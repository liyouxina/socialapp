package com.example.socialcontactapp;

import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.io.FileUtil;
import com.example.socialcontactapp.utils.R;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.IOException;

import static com.example.socialcontactapp.utils.RegexPatterns.PHONE_REGEX;

/**
 * @question
 * @Author xiyuan
 * @Date 2022/6/16 10:35
 * @Version 1.0
 */
public class test {
    public static void main(String[] args) {
        loginByPassword(null, "");
    }

    public static R loginByPassword(String password, String tel) {
        System.out.println(password);
        System.out.println(tel);
        return null;
    }

    @Test
    public void test() {
//        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidXNlcjk3ODYzNTY2IiwiaWQiOiI5Nzg2MzU2NiIsImV4cCI6MTY1NTk4Njc3MH0.0W8VWMFXWH0NL9lz1v-GB2dcZwz1G1z-O1FKPwEEegM";
//        System.out.println(System.currentTimeMillis());
//        System.out.println(JWTUtil.getToken(new HashMap<>()));
//        System.out.println(JWTUtil.getString(token, "userId"));
//        long l = System.currentTimeMillis();
//        System.out.println(l);
//        System.out.println(Long.valueOf(String.valueOf(l)));
//        Long l1 = 2678400000L;
//        long l2 = 2678400000L;
//        Pattern compile = Pattern.compile(PHONE_REGEX);
//        System.out.println(compile);
        System.out.println("15899714622".matches(PHONE_REGEX));
    }
}
