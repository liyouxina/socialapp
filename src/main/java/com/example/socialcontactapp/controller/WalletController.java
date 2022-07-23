package com.example.socialcontactapp.controller;

import com.example.socialcontactapp.service.WalletService;
import com.example.socialcontactapp.utils.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Wallet)表控制层
 *
 * @author makejava
 * @since 2022-06-18 19:42:53
 */
@RestController
@RequestMapping("wallet")
public class WalletController {
    /**
     * 服务对象
     */
    @Resource
    private WalletService walletService;

    /**
     * 通过主键查询单条数据
     *
     * @return 单条数据
     */
    @GetMapping("money")
    public R queryMoney(String token) {
        return this.walletService.queryWallet(token);
    }
    @GetMapping("rewardRecord")
    public R queryRewardRecord(String token) {
        return this.walletService.queryRewardRecord(token);
    }

}