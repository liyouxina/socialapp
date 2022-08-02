package com.example.socialcontactapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.Date;
import java.io.Serializable;

/**
 * (RechargeRecorder)实体类
 *
 * @author makejava
 * @since 2022-06-25 15:22:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class RechargeRecorder implements Serializable {
    private static final long serialVersionUID = -41221314586074712L;
    
    private Integer id;
    
    private Long userid;
    
    private LocalDateTime datetime;
    
    private String money;
    /**
    * 1表示微信，2表示支付宝
    */
    private Integer type;



}