package com.example.socialcontactapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * (Dynamicmessage)实体类
 *
 * @author makejava
 * @since 2022-06-16 08:11:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Dynamicmessage implements Serializable {
    private static final long serialVersionUID = -81028754367230221L;
    private List<MultipartFile> list;
    private Integer messageid;

    private Long userid;

    private LocalDateTime datatime;

    private String label;

    private String address;

    private Integer nums;

    private String topic;

    private String pictures;

    private String content;

    private Integer comment;

    private Integer enroll;

    private Integer love;


}