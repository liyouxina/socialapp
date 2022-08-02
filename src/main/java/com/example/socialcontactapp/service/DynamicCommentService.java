package com.example.socialcontactapp.service;

import com.example.socialcontactapp.entity.DynamicComment;
import com.example.socialcontactapp.utils.R;

import java.util.List;

/**
 * (DynamicComment)表服务接口
 *
 * @author makejava
 * @since 2022-06-25 18:05:37
 */
public interface DynamicCommentService {


    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */


    R queryAllByLimit(Integer message, int offset, int limit);

    /**
     * 新增数据
     *
     * @param dynamicComment 实例对象
     * @return 实例对象
     */

    R insert(String token, DynamicComment dynamicComment);




    /**
     * 通过主键删除数据
     *
     * @param messageid 主键
     * @return 是否成功
     */

    R deleteById(String token, Integer messageid);
}