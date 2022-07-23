package com.example.socialcontactapp.service;

import com.example.socialcontactapp.entity.Drawmoney;
import java.util.List;

/**
 * (Drawmoney)表服务接口
 *
 * @author makejava
 * @since 2022-06-16 08:11:57
 */
public interface DrawmoneyService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Drawmoney queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Drawmoney> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param drawmoney 实例对象
     * @return 实例对象
     */
    Drawmoney insert(Drawmoney drawmoney);

    /**
     * 修改数据
     *
     * @param drawmoney 实例对象
     * @return 实例对象
     */
    Drawmoney update(Drawmoney drawmoney);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}