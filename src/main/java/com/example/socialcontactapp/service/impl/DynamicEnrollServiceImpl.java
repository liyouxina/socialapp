package com.example.socialcontactapp.service.impl;

import com.example.socialcontactapp.entity.DynamicEnroll;
import com.example.socialcontactapp.dao.DynamicEnrollDao;
import com.example.socialcontactapp.service.DynamicEnrollService;
import com.example.socialcontactapp.utils.R;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (DynamicEnroll)表服务实现类
 *
 * @author makejava
 * @since 2022-06-25 18:06:04
 */
@Service("dynamicEnrollService")
public class DynamicEnrollServiceImpl implements DynamicEnrollService {
    @Resource
    private DynamicEnrollDao dynamicEnrollDao;


    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<DynamicEnroll> queryAllByLimit(int offset, int limit) {
        return this.dynamicEnrollDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param dynamicEnroll 实例对象
     * @return 实例对象
     */
    @Override
    public DynamicEnroll insert(DynamicEnroll dynamicEnroll) {
        this.dynamicEnrollDao.insert(dynamicEnroll);
        return dynamicEnroll;
    }

    /**
     * 修改数据
     *
     * @param dynamicEnroll 实例对象
     * @return 实例对象
     */


    /**
     * 通过主键删除数据
     *
     * @param messageid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer messageid) {
        return this.dynamicEnrollDao.deleteById(messageid) > 0;
    }
}