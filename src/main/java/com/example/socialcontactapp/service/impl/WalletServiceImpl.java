package com.example.socialcontactapp.service.impl;

import cn.hutool.core.util.StrUtil;
import com.example.socialcontactapp.dao.RewardrecordDao;
import com.example.socialcontactapp.dao.WalletDao;
import com.example.socialcontactapp.entity.Rewardrecord;
import com.example.socialcontactapp.entity.Wallet;
import com.example.socialcontactapp.service.WalletService;
import com.example.socialcontactapp.utils.JWTUtil;
import com.example.socialcontactapp.utils.R;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Wallet)表服务实现类
 *
 * @author makejava
 * @since 2022-06-18 19:42:53
 */
@Service("walletService")
public class WalletServiceImpl implements WalletService {
    @Resource
    private WalletDao walletDao;
    @Resource
    private RewardrecordDao rewardrocordDao;

    /**
     * 通过ID查询单条数据
     *
     * @return 实例对象
     */
    @Override
    public R queryWallet(String token) {
        Long userId = JWTUtil.getUserId(token);
        if (StrUtil.isBlank(token))
            return R.error().data("msg", "验证过期");
        Wallet wallet = this.walletDao.queryById(userId);
        return R.ok().data("data", wallet);
    }

    @Override
    public R queryRewardRecord(String token) {
        Long userId = JWTUtil.getUserId(token);
        if (StrUtil.isBlank(token))
            return R.error().data("msg", "验证过期");
        List<Rewardrecord> rewardRecords = this.rewardrocordDao.queryAllByLimit(userId);
        return R.ok().data("data", rewardRecords);
    }


}