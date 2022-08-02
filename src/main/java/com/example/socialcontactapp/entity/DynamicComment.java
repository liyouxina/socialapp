package com.example.socialcontactapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.Date;
import java.io.Serializable;

/**
 * (DynamicComment)实体类
 *
 * @author makejava
 * @since 2022-06-25 18:05:37
 */@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class DynamicComment implements Serializable {
    private static final long serialVersionUID = -54598437672339093L;
    
    private Integer messageid;
    
    private Long userid;
    
    private String comment;
    
    private LocalDateTime datatime;




}