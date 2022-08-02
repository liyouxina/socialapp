package com.example.socialcontactapp.dao;

import com.example.socialcontactapp.entity.Dynamicmessage;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * (Dynamicmessage)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-16 08:11:57
 */
@Mapper
public interface DynamicmessageDao {

    /**
     * 通过ID查询单条数据
     *
     * @param messageid 主键
     * @return 实例对象
     */
    Dynamicmessage queryById(Integer messageid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Dynamicmessage> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param dynamicmessage 实例对象
     * @return 对象列表
     */
    List<Dynamicmessage> queryAll(Dynamicmessage dynamicmessage);

    /**
     * 新增数据
     *
     * @param dynamicmessage 实例对象
     * @return 影响行数
     */
    @Insert(" insert into socialContactApp.dynamicMessage(userId, datatime, label, address, nums, topic, pictures, content)\n" +
            "        values (#{userid}, #{datatime}, #{label}, #{address}, #{nums}, #{topic}, #{pictures}, #{content})")
    int insert(Dynamicmessage dynamicmessage);

    /**
     * 修改数据
     *
     * @param dynamicmessage 实例对象
     * @return 影响行数
     */
    int update(Dynamicmessage dynamicmessage);

    /**
     * 通过主键删除数据
     *
     * @param messageid 主键
     * @return 影响行数
     */
    @Delete("delete from socialContactApp.dynamicMessage where messageId = #{messageid} and userId = #{userId}")
    int deleteById(Integer messageid, Long userId);

    @Select("select * from dynamicMessage where userId  = #{userId} limit #{offset},10;")
    List<Dynamicmessage> queryByUserId(Long userId, int offset);

    @Update("update dynamicMessage set comment_count = comment_count + 1  where messageId  = #{messageId};")
    int addComment(Integer messageId);

    @Update("update dynamicMessage set comment_count = comment_count - 1  where messageId  = #{messageId};")
    int reduceComment(Integer messageId);

    @Update("update dynamicMessage set enroll_count = enroll_count + 1  where messageId  = #{messageId};")
    int addEnroll(Integer messageId);
    @Update("update dynamicMessage set enroll_count = enroll_count - 1  where messageId  = #{messageId};")
    int reduceEnroll(Integer messageId);

    @Update("update dynamicMessage set love_count = love_count + 1  where messageId  = #{messageId};")
    int addLove(Integer messageId);


}