package com.example.socialcontactapp.dao;

import com.example.socialcontactapp.entity.Rewardrecord;

import java.util.List;

/**
 * (Rewardrecord)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-18 21:41:14
 */
public interface RewardrecordDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Rewardrecord queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @return 对象列表
     */
    List<Rewardrecord> queryAllByLimit(Long userId);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param rewardrecord 实例对象
     * @return 对象列表
     */
    List<Rewardrecord> queryAll(Rewardrecord rewardrecord);

    /**
     * 新增数据
     *
     * @param rewardrecord 实例对象
     * @return 影响行数
     */
    int insert(Rewardrecord rewardrecord);

    /**
     * 修改数据
     *
     * @param rewardrecord 实例对象
     * @return 影响行数
     */
    int update(Rewardrecord rewardrecord);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}