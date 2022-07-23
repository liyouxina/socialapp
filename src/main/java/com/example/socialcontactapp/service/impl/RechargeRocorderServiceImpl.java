package com.example.socialcontactapp.service.impl;

import com.example.socialcontactapp.dao.RechargeRecorderDao;
import com.example.socialcontactapp.entity.RechargeRecorder;
import com.example.socialcontactapp.service.RechargeRocorderService;
import com.example.socialcontactapp.utils.JWTUtil;
import com.example.socialcontactapp.utils.R;
import com.example.socialcontactapp.utils.Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (RechargeRecorder)表服务实现类
 *
 * @author makejava
 * @since 2022-06-25 15:22:58
 */
@Service("rechargeRocorderService")
public class RechargeRocorderServiceImpl implements RechargeRocorderService {
    @Resource
    private RechargeRecorderDao rechargeRecorderDao;


    @Override
    public R queryAllByLimit(String token, int offset, int limit) {
        Long userId = JWTUtil.getUserId(token);
        List<RechargeRecorder> rechargeRecorders = this.rechargeRecorderDao.queryAllByLimit(userId, offset, limit);
        return R.ok().data("data", rechargeRecorders);
    }

    /**
     * 新增数据
     *
     * @param rechargeRecorder 实例对象
     * @return 实例对象
     */
    @Override
    public R insert(String token, RechargeRecorder rechargeRecorder) {
        Long userId = JWTUtil.getUserId(token);
        if(userId == null){
            return R.error().data("msg","用户验证过期");
        }
        rechargeRecorder.setUserid(userId);
        rechargeRecorder.setDatetime(Util.now());
        if (this.rechargeRecorderDao.insert(rechargeRecorder) <= 0) {
            return R.error().data("msg", "插入失败");
        }
        return R.ok().data("msg", "添加成功");
    }


}