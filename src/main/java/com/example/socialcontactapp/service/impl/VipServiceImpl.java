package com.example.socialcontactapp.service.impl;

import com.example.socialcontactapp.dao.VipDao;
import com.example.socialcontactapp.entity.Vip;
import com.example.socialcontactapp.service.VipService;
import com.example.socialcontactapp.utils.R;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Vip)表服务实现类
 *
 * @author makejava
 * @since 2022-06-16 08:11:57
 */
@Service
public class VipServiceImpl implements VipService {
    @Resource
    private VipDao vipDao;
    /**
     * 查询多条数据
     *
     * @return 对象列表
     */
    @Override
    public R queryAll() {

        List<Vip> vips = this.vipDao.queryAll();
        if (vips == null)
            return R.error().data("msg", "服务器错误");
        return R.ok().data("msg", vips);
    }


}