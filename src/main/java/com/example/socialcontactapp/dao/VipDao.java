package com.example.socialcontactapp.dao;

import com.example.socialcontactapp.entity.Vip;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * (Vip)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-16 08:11:57
 */
public interface VipDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Vip queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Vip> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param vip 实例对象
     * @return 对象列表
     */
//    List<Vip> queryAll(Vip vip);
//
    /**
     * 新增数据
     *
     * @param vip 实例对象
     * @return 影响行数
     */
    int insert(Vip vip);

    /**
     * 修改数据
     *
     * @param vip 实例对象
     * @return 影响行数
     */
    int update(Vip vip);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    @Select("select * from vip;")
    List<Vip> queryAll();
}