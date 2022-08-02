package com.example.socialcontactapp.service;

import com.example.socialcontactapp.entity.Wallet;
import com.example.socialcontactapp.utils.R;

import java.util.List;

/**
 * (Wallet)表服务接口
 *
 * @author makejava
 * @since 2022-06-18 19:42:53
 */
public interface WalletService {

    /**
     * 通过ID查询单条数据
     *
     * @return 实例对象
     */


    R queryWallet(String token);

    R queryRewardRecord(String token);
}