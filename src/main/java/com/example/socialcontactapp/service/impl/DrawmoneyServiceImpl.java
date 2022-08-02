package com.example.socialcontactapp.service.impl;

import com.example.socialcontactapp.entity.Drawmoney;
import com.example.socialcontactapp.dao.DrawmoneyDao;
import com.example.socialcontactapp.service.DrawmoneyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Drawmoney)表服务实现类
 *
 * @author makejava
 * @since 2022-06-16 08:11:57
 */
@Service
public class DrawmoneyServiceImpl implements DrawmoneyService {
    @Resource
    private DrawmoneyDao drawmoneyDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Drawmoney queryById(Integer id) {
        return this.drawmoneyDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Drawmoney> queryAllByLimit(int offset, int limit) {
        return this.drawmoneyDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param drawmoney 实例对象
     * @return 实例对象
     */
    @Override
    public Drawmoney insert(Drawmoney drawmoney) {
        this.drawmoneyDao.insert(drawmoney);
        return drawmoney;
    }

    /**
     * 修改数据
     *
     * @param drawmoney 实例对象
     * @return 实例对象
     */
    @Override
    public Drawmoney update(Drawmoney drawmoney) {
        this.drawmoneyDao.update(drawmoney);
        return this.queryById(drawmoney.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.drawmoneyDao.deleteById(id) > 0;
    }
}