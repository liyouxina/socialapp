package com.example.socialcontactapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (Wallet)实体类
 *
 * @author makejava
 * @since 2022-06-18 19:42:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Wallet implements Serializable {
    private static final long serialVersionUID = -27140587140806371L;
    
    private Integer id;
    
    private Long userid;
    
    private Float reward;
    
    private Float recharge;
}