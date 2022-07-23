package com.example.socialcontactapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (Complaint)实体类
 *
 * @author makejava
 * @since 2022-06-16 08:11:57
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Complaint implements Serializable {
    private static final long serialVersionUID = -78591787535396236L;
    
    private Integer id;
    
    private Long userid;
    
    private String content;
    
    private String picture1;
    
    private String picture2;
    
    private String picture3;



}