package com.example.socialcontactapp.controller;

import com.example.socialcontactapp.service.BuyVipRecordService;
import com.example.socialcontactapp.utils.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (BuyVipRecorder)表控制层
 *
 * @author makejava
 * @since 2022-06-17 09:35:23
 */
@RestController
@RequestMapping("buyviprecord")
public class BuyVipRecordController {
    /**
     * 服务对象
     */
    @Resource
    private BuyVipRecordService buyVipRecordService;

    @PostMapping()
    public R buy(String token, Integer typeId) {
        return this.buyVipRecordService.insert(token, typeId);
    }

    @GetMapping()
    public R queryByUserId(String token, Integer offset) {
        if (offset == null)
            return R.error().data("msg", "错误");
        return this.buyVipRecordService.queryByUserId(token, offset);
    }
}