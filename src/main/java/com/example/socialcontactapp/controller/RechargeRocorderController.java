package com.example.socialcontactapp.controller;

import com.example.socialcontactapp.entity.RechargeRecorder;
import com.example.socialcontactapp.service.RechargeRocorderService;
import com.example.socialcontactapp.utils.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (RechargeRecorder)表控制层
 *
 * @author makejava
 * @since 2022-06-25 15:22:58
 */
@RestController
@RequestMapping("rechargeRocorder")
public class RechargeRocorderController {
    /**
     * 服务对象
     */
    @Resource
    private RechargeRocorderService rechargeRocorderService;

    /**
     * 通过主键查询单条数据
     *
     * @return 单条数据
     */
    @GetMapping("")
    public R selectOne(String token, int offset, int limit) {
        return this.rechargeRocorderService.queryAllByLimit(token, offset, limit);
    }
    @PostMapping("")
    public R insert(String token, RechargeRecorder recorder){
        return this.rechargeRocorderService.insert(token,recorder);
    }

}