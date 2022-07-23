package com.example.socialcontactapp.dao;

import com.example.socialcontactapp.entity.RechargeRecorder;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (RechargeRecorder)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-25 15:22:58
 */
public interface RechargeRecorderDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RechargeRecorder queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<RechargeRecorder> queryAllByLimit(Long userId, @Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param rechargeRecorder 实例对象
     * @return 对象列表
     */
    List<RechargeRecorder> queryAll(RechargeRecorder rechargeRecorder);

    /**
     * 新增数据
     *
     * @param rechargeRecorder 实例对象
     * @return 影响行数
     */
    int insert(RechargeRecorder rechargeRecorder);

    /**
     * 修改数据
     *
     * @param rechargeRecorder 实例对象
     * @return 影响行数
     */
    int update(RechargeRecorder rechargeRecorder);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}