package com.example.socialcontactapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (Drawmoney)实体类
 *
 * @author makejava
 * @since 2022-06-16 08:11:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Drawmoney implements Serializable {
    private static final long serialVersionUID = -88713014980602472L;

    private Integer id;

    private Integer userid;

    private String drawing;


}