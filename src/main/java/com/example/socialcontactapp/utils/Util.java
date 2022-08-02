package com.example.socialcontactapp.utils;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

/**
 * @question
 * @Author xiyuan
 * @Date 2022/4/7 22:01
 * @Version 1.0
 */

public class Util {
    public static LocalDateTime now() {
        return LocalDateTime.now();
    }
    public static String getRandomId(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
