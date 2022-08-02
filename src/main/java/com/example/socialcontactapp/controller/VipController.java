package com.example.socialcontactapp.controller;

import com.example.socialcontactapp.service.VipService;
import com.example.socialcontactapp.utils.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Vip)表控制层
 *
 * @author makejava
 * @since 2022-06-16 08:11:57
 */
@RestController
@RequestMapping("vip")
public class VipController {
    /**
     * 服务对象
     */
    @Resource
    private VipService vipService;

    /**
     * 通过主键查询单条数据
     *
     * @return 单条数据
     */
    @GetMapping()
    public R queryAllByLimit() {
        return this.vipService.queryAll();
    }
}