package com.example.socialcontactapp.service;

import com.example.socialcontactapp.entity.Viprecord;

import java.util.List;

/**
 * (Viprecord)表服务接口
 *
 * @author makejava
 * @since 2022-06-18 20:59:26
 */
public interface ViprecordService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Viprecord queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Viprecord> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param viprecord 实例对象
     * @return 实例对象
     */
    Viprecord insert(Viprecord viprecord);

    /**
     * 修改数据
     *
     * @param viprecord 实例对象
     * @return 实例对象
     */
    Viprecord update(Viprecord viprecord);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}