package com.example.socialcontactapp.service;

import com.example.socialcontactapp.entity.Userdetails;
import com.example.socialcontactapp.utils.R;

import java.util.List;

/**
 * (Userdetails)表服务接口
 *
 * @author makejava
 * @since 2022-06-16 08:11:57
 */
public interface UserdetailsService {

    /**
     * 通过ID查询单条数据
     *
     * @return 实例对象
     */

    R queryById(String token);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Userdetails> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param userdetails 实例对象
     * @return 实例对象
     */

    R insert(String token, Userdetails userdetails);

    /**
     * 修改数据
     *
     * @param userdetails 实例对象
     * @return 实例对象
     */


    R update(String token, Userdetails userdetails);
}