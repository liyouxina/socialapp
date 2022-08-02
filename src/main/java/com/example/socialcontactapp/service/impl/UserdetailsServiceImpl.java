package com.example.socialcontactapp.service.impl;

import com.aliyun.tea.utils.StringUtils;
import com.example.socialcontactapp.dao.UserdetailsDao;
import com.example.socialcontactapp.entity.Userdetails;
import com.example.socialcontactapp.service.UserdetailsService;
import com.example.socialcontactapp.utils.JWTUtil;
import com.example.socialcontactapp.utils.R;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * (Userdetails)表服务实现类
 *
 * @author makejava
 * @since 2022-06-16 08:11:57
 */
@Service
public class UserdetailsServiceImpl implements UserdetailsService {
    @Resource
    private UserdetailsDao userdetailsDao;

    /**
     * 通过ID查询单条数据
     *
     * @return 实例对象
     */
    @Override
    public R queryById(String token) {
        Long userId = JWTUtil.getUserId(token);
        if (userId == null)
            return R.error().data("msg", "用户信息已过期");
        Userdetails userdetails = this.userdetailsDao.queryById(userId);
        return R.ok().data("data", userdetails);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Userdetails> queryAllByLimit(int offset, int limit) {
        return this.userdetailsDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<Userdetails> queryNear(String city, int offset, int limit) {
        return this.userdetailsDao.queryNear(city, offset, limit);
    }

    @Override
    public List<Userdetails> search(String content) {
        if (!StringUtils.isEmpty(content)) {
            return this.userdetailsDao.search(content);
        }
        return Collections.emptyList();
    }
    /**
     * 新增数据
     *
     * @param userdetails 实例对象
     * @return 实例对象
     */
    @Override
    public R insert(String token, Userdetails userdetails) {
        Long userId = JWTUtil.getUserId(token);
        userdetails.setUserid(userId);
        this.userdetailsDao.insert(userdetails);
        return R.ok().data("msg","成功添加");
    }

    /**
     * 修改数据
     *
     * @param userdetails 实例对象
     * @return 实例对象
     */
    @Override
    public R update(String token,Userdetails userdetails) {
        Long userId = JWTUtil.getUserId(token);
        if(userId == null)
            return R.error().data("msg","用户验证过期");
        userdetails.setUserid(userId);
        this.userdetailsDao.update(userdetails);
        return R.ok().data("msg","修改成功");
    }

    @Override
    public R insertOrUpdate(String token, Userdetails userdetails) {
        Long userId = JWTUtil.getUserId(token);
        if(userId == null)
            return R.error().data("msg","用户验证过期");
        Userdetails userdetailsOld = userdetailsDao.queryById(userId);
        userdetails.setUserid(userId);
        if (userdetailsOld == null) {
            userdetailsDao.insert(userdetails);
        } else {
            userdetailsDao.update(userdetails);
        }
        return R.ok().data("msg","成功");
    }
}