package com.example.socialcontactapp.dao;

import com.example.socialcontactapp.entity.BuyVipRecorder;
import com.example.socialcontactapp.entity.Record;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * (BuyVipRecorder)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-17 09:35:23
 */
public interface BuyVipRecordDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BuyVipRecorder queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<BuyVipRecorder> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param buyVipRecorder 实例对象
     * @return 对象列表
     */
    List<BuyVipRecorder> queryAll(BuyVipRecorder buyVipRecorder);

    /**
     * 新增数据
     *
     * @param buyVipRecorder 实例对象
     * @return 影响行数
     */
    int insert(BuyVipRecorder buyVipRecorder);

    /**
     * 修改数据
     *
     * @param buyVipRecorder 实例对象
     * @return 影响行数
     */
    int update(BuyVipRecorder buyVipRecorder);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

        @Select("select  vip.type,buyingRecord.recharge, buyingRecord.datetime from buyingRecord,vip " +
            "where buyingRecord.userId = #{userId} and vip.id = buyingRecord.typeId limit #{offset},#{limit} ;")
    List<Record> queryByUserId(Long userId, int offset, int limit);
}