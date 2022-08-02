package com.example.socialcontactapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

import java.io.Serializable;

/**
 * (BuyVipRecorder)实体类
 *
 * @author makejava
 * @since 2022-06-17 09:35:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class BuyVipRecorder implements Serializable {
    private static final long serialVersionUID = -12067210439494596L;

    private Integer id;

    private Long userid;

    private Integer typeid;
    /**
    * 充值
    */
    private Integer recharge;

    private LocalDateTime datetime;

    private Long inviteeid;

}