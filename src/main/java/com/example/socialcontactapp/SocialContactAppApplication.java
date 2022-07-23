package com.example.socialcontactapp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.socialcontactapp.dao")
public class SocialContactAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SocialContactAppApplication.class, args);
    }

}
