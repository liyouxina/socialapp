package com.example.socialcontactapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @question
 * @Author xiyuan
 * @Date 2022/6/17 9:46
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Record {
    private String type;
    private Integer recharge;
    private LocalDateTime datetime;
}
