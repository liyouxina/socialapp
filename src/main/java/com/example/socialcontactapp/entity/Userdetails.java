package com.example.socialcontactapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (Userdetails)实体类
 *
 * @author makejava
 * @since 2022-06-16 08:11:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Userdetails implements Serializable {
    private static final long serialVersionUID = -91006446965059142L;
    
    private Long userid;
    
    private String sex;
    
    private String nickname;
    
    private Integer height;
    
    private Integer weight;
    
    private String city;
    
    private String work;
    
    private String word;
    
    private String wechatid;
    
    private String vip;
    
    private String invitationcode;



}