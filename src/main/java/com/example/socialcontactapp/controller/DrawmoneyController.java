package com.example.socialcontactapp.controller;

import com.example.socialcontactapp.entity.Drawmoney;
import com.example.socialcontactapp.service.DrawmoneyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Drawmoney)表控制层
 *
 * @author makejava
 * @since 2022-06-16 08:11:57
 */
@RestController
@RequestMapping("drawmoney")
public class DrawmoneyController {
    /**
     * 服务对象
     */
    @Resource
    private DrawmoneyService drawmoneyService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Drawmoney selectOne(Integer id) {
        return this.drawmoneyService.queryById(id);
    }

}