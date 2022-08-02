package com.example.socialcontactapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class SocialContactAppApplicationTests {
    @Autowired
    private StringRedisTemplate redisTemplate;

}
