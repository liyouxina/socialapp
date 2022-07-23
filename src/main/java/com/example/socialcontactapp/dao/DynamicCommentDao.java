package com.example.socialcontactapp.dao;

import com.example.socialcontactapp.entity.DynamicComment;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (DynamicComment)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-25 18:05:37
 */
public interface DynamicCommentDao {

    /**
     * 通过ID查询单条数据
     *
     * @param messageid 主键
     * @return 实例对象
     */
    DynamicComment queryById(Integer messageid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<DynamicComment> queryAllByLimit(Integer messageId,@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param dynamicComment 实例对象
     * @return 对象列表
     */
    List<DynamicComment> queryAll(DynamicComment dynamicComment);

    /**
     * 新增数据
     *
     * @param dynamicComment 实例对象
     * @return 影响行数
     */
    int insert(DynamicComment dynamicComment);

    /**
     * 修改数据
     *
     * @param dynamicComment 实例对象
     * @return 影响行数
     */
    int update(DynamicComment dynamicComment);

    /**
     * 通过主键删除数据
     *
     * @param messageid 主键
     * @return 影响行数
     */
    int deleteById(Integer messageid ,Long userId);

}