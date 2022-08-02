package com.example.socialcontactapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (Vip)实体类
 *
 * @author makejava
 * @since 2022-06-16 08:11:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Vip implements Serializable {
    private static final long serialVersionUID = 696552862658677731L;
    
    private Integer id;
    
    private String type;
    
    private Integer money;
    
    private String days;




}