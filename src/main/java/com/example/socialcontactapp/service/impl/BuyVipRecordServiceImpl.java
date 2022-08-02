package com.example.socialcontactapp.service.impl;

import com.example.socialcontactapp.dao.*;
import com.example.socialcontactapp.entity.BuyVipRecorder;
import com.example.socialcontactapp.entity.Record;
import com.example.socialcontactapp.entity.Rewardrecord;
import com.example.socialcontactapp.entity.Vip;
import com.example.socialcontactapp.service.BuyVipRecordService;
import com.example.socialcontactapp.utils.JWTUtil;
import com.example.socialcontactapp.utils.R;
import com.example.socialcontactapp.utils.Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BuyVipRecorder)表服务实现类
 *
 * @author makejava
 * @since 2022-06-17 09:35:23
 */
@Service("buyingrecordService")
public class BuyVipRecordServiceImpl implements BuyVipRecordService {
    @Resource
    private BuyVipRecordDao buyVipRecordDao;
    @Resource
    private UserDao userDao;
    @Resource
    private WalletDao walletDao;
    @Resource
    private VipDao vipDao;
    @Resource
    private RewardrecordDao rewardrocordDao;

    /**
     * 新增数据
     *
     * @return 实例对象
     */
    @Override
    public R insert(String token, Integer typeId) {
        Long userId = JWTUtil.getUserId(token);
        if (userId == null)
            return R.error().data("msg", "验证过期");
        BuyVipRecorder record = new BuyVipRecorder();
        Long inviteeId = this.userDao.queryInvitee(userId);
        Vip vip = this.vipDao.queryById(typeId);
        Integer recharge = vip.getMoney();
        if (inviteeId != null) {
            this.walletDao.addReward(inviteeId, recharge * 0.2f);
            this.rewardrocordDao.insert(new Rewardrecord().setDatetime(Util.now()).setTypeid(typeId).setUserid(inviteeId));
        }
        record.setDatetime(Util.now()).setTypeid(typeId).setRecharge(recharge).setUserid(userId);
        this.buyVipRecordDao.insert(record);
        return R.ok().data("msg", "购买成功");
    }

    @Override
    public R queryByUserId(String token, int offset) {
        Long userId = JWTUtil.getUserId(token);
        if (userId == null)
            return R.error().data("msg", "验证过期");
        List<Record> list = this.buyVipRecordDao.queryByUserId(userId, offset, 10);
        return R.ok().data("data", list);
    }

}