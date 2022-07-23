package com.example.socialcontactapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.Date;
import java.io.Serializable;

/**
 * (Rewardrecord)实体类
 *
 * @author makejava
 * @since 2022-06-18 21:41:06
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Rewardrecord implements Serializable {
    private static final long serialVersionUID = -30188342537770509L;
    
    private Integer id;
    
    private Long userid;
    
    private Integer typeid;
    
    private LocalDateTime datetime;



}