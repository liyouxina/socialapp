package com.example.socialcontactapp.controller;

import com.example.socialcontactapp.entity.DynamicEnroll;
import com.example.socialcontactapp.service.DynamicEnrollService;
import com.example.socialcontactapp.utils.R;
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

    @GetMapping("getDynamicEnroll")
    public R getDynamicEnroll(String token, int limit, int offset) {
        return R.ok().data("list", dynamicEnrollService.queryAllByLimit(offset, limit));
    }

}