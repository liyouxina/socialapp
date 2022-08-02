package com.example.socialcontactapp.dao;

import com.example.socialcontactapp.entity.Wallet;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * (Wallet)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-18 19:42:53
 */
public interface WalletDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Wallet queryById(Long userId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Wallet> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param wallet 实例对象
     * @return 对象列表
     */
    List<Wallet> queryAll(Wallet wallet);

    /**
     * 新增数据
     *
     * @param wallet 实例对象
     * @return 影响行数
     */
    int insert(Wallet wallet);

    /**
     * 修改数据
     *
     * @param wallet 实例对象
     * @return 影响行数
     */
    int update(Wallet wallet);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    @Update("update wallet set reward = reward+#{reward} where  userId = #{inviteeId};")
    int addReward(Long inviteeId, Float reward);
}