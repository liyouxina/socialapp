package com.example.socialcontactapp.utils;

import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.Map;

/**
 * @question
 * @Author xiyuan
 * @Date 2022/3/29 15:46
 * @Version 1.0
 */
public class JWTUtil {
    public static final String KEY = "^&*&fdsf*(fddfds}$#";
    //30天
    public final static long EXPIRE_TIME = 30 * 24 * 60 * 60 * 1000L;

    /**
     * 生成token header.payload.sing
     */
    public static String getToken(Map<String, String> map) {
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        //创建JWT builder
        JWTCreator.Builder builder = JWT.create();
        // payload
        map.forEach((k, v) -> {
            builder.withClaim(k, v); //这里可以存放 用户id，用户名
        });
        //指定过期时间，sign ，生成token  这里的签名是指定好的
        //实际项目中可以 接收用户的密码来做签名,这样每一个用户对应一个签名
        String token = builder.withExpiresAt(date).sign(Algorithm.HMAC256(KEY));
        return token;
    }

    /**
     * 验证token合法性
     */
    public static DecodedJWT verify(String token) {
        return JWT.require(Algorithm.HMAC256(KEY)).build().verify(token);
    }

    public static String getString(String token, String name) {
        DecodedJWT verify = JWT.require(Algorithm.HMAC256(KEY)).build().verify(token);
        return verify.getClaim(name).asString();
    }

    public static Long getUserId(String token) {
        if (StrUtil.isBlank(token))
            return null;
        DecodedJWT verify = null;
        try {
            verify = JWTUtil.verify(token);
        } catch (Exception e) {
            return null;
        }
        return Long.valueOf(verify.getClaim("id").asString());
    }
}
