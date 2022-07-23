package com.example.socialcontactapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;
import java.io.Serializable;

/**
 * (DynamicEnroll)实体类
 *
 * @author makejava
 * @since 2022-06-25 18:06:04
 */@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class DynamicEnroll implements Serializable {
    private static final long serialVersionUID = -57695666653637150L;
    
    private Integer messageid;
    
    private Long userid;
    
    private Date datetime;



}