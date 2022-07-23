package com.example.socialcontactapp.dao;

import com.example.socialcontactapp.entity.Userdetails;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * (Userdetails)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-16 08:11:57
 */
public interface UserdetailsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param userid 主键
     * @return 实例对象
     */
    Userdetails queryById(Long userid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Userdetails> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param userdetails 实例对象
     * @return 对象列表
     */
    List<Userdetails> queryAll(Userdetails userdetails);

    /**
     * 新增数据
     *
     * @param userdetails 实例对象
     * @return 影响行数
     */
    int insert(Userdetails userdetails);

    /**
     * 修改数据
     *
     * @param userdetails 实例对象
     * @return 影响行数
     */
    int update(Userdetails userdetails);

    /**
     * 通过主键删除数据
     *
     * @param userid 主键
     * @return 影响行数
     */
    int deleteById(Integer userid);

    @Select("select userId from userDetails where invitationCode = #{invitationCode};")
    Long queryByinvitationCode(String invitationCode);
}