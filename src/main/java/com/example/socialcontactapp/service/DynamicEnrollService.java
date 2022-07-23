package com.example.socialcontactapp.service;

import com.example.socialcontactapp.entity.DynamicEnroll;
import java.util.List;

/**
 * (DynamicEnroll)表服务接口
 *
 * @author makejava
 * @since 2022-06-25 18:06:04
 */
public interface DynamicEnrollService {

    /**
     * 通过ID查询单条数据
     *
     * @param messageid 主键
     * @return 实例对象
     */

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<DynamicEnroll> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param dynamicEnroll 实例对象
     * @return 实例对象
     */
    DynamicEnroll insert(DynamicEnroll dynamicEnroll);

    /**
     * 修改数据
     *
     * @param dynamicEnroll 实例对象
     * @return 实例对象
     */


    /**
     * 通过主键删除数据
     *
     * @param messageid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer messageid);

}