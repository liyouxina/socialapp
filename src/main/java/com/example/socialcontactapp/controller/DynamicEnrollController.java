package com.example.socialcontactapp.controller;

import com.example.socialcontactapp.entity.DynamicEnroll;
import com.example.socialcontactapp.service.DynamicEnrollService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (DynamicEnroll)表控制层
 *
 * @author makejava
 * @since 2022-06-25 18:06:04
 */
@RestController
@RequestMapping("dynamicEnroll")
public class DynamicEnrollController {
    /**
     * 服务对象
     */
    @Resource
    private DynamicEnrollService dynamicEnrollService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */


}