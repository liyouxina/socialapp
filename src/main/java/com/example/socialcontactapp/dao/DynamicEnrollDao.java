package com.example.socialcontactapp.dao;

import com.example.socialcontactapp.entity.DynamicEnroll;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * (DynamicEnroll)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-25 18:06:04
 */
public interface DynamicEnrollDao {

    /**
     * 通过ID查询单条数据
     *
     * @param messageid 主键
     * @return 实例对象
     */
    DynamicEnroll queryById(Integer messageid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<DynamicEnroll> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param dynamicEnroll 实例对象
     * @return 对象列表
     */
    List<DynamicEnroll> queryAll(DynamicEnroll dynamicEnroll);

    /**
     * 新增数据
     *
     * @param dynamicEnroll 实例对象
     * @return 影响行数
     */
    int insert(DynamicEnroll dynamicEnroll);

    /**
     * 修改数据
     *
     * @param dynamicEnroll 实例对象
     * @return 影响行数
     */
    int update(DynamicEnroll dynamicEnroll);

    /**
     * 通过主键删除数据
     *
     * @param messageid 主键
     * @return 影响行数
     */
    int deleteById(Integer messageid);

    @Select("select count(*) from dynamic_enroll where messageId = #{messageId};")
    int queryCount(Integer messageId);
}