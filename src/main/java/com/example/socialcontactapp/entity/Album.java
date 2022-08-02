package com.example.socialcontactapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (Album)实体类
 *
 * @author makejava
 * @since 2022-06-16 08:11:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Album implements Serializable {
    private static final long serialVersionUID = -81105534953728147L;

    private Integer id;

    private Integer userid;

    private String picture;


}