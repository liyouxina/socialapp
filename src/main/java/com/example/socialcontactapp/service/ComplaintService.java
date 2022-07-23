package com.example.socialcontactapp.service;

import com.example.socialcontactapp.entity.Complaint;
import com.example.socialcontactapp.utils.R;

import java.util.List;

/**
 * (Complaint)表服务接口
 *
 * @author makejava
 * @since 2022-06-16 08:11:57
 */
public interface ComplaintService {




    /**
     * 新增数据
     *
     * @param complaint 实例对象
     * @return 实例对象
     */

    R insert(String token, Complaint complaint);


}