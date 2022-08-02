package com.example.socialcontactapp.controller;

import com.example.socialcontactapp.entity.Userdetails;
import com.example.socialcontactapp.service.UserdetailsService;
import com.example.socialcontactapp.utils.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Userdetails)表控制层
 *
 * @author makejava
 * @since 2022-06-16 08:11:57
 */
@CrossOrigin
@RestController
@RequestMapping("userdetails")
public class UserdetailsController {
    /**
     * 服务对象
     */
    @Resource
    private UserdetailsService userdetailsService;

    /**
     * 通过主键查询单条数据
     *
     * @return 单条数据
     */
    @GetMapping("getOneDetails")
    public R getOneDetails(String token) {
        return this.userdetailsService.queryById(token);
    }


    /**
     * 新增数据
     *
     * @param userdetails 实例对象
     * @return 实例对象
     */
    @PostMapping()
    public R insert(String token, Userdetails userdetails){
        return this.userdetailsService.insert(token, userdetails);
    }

    /**
     * 修改数据
     *
     * @param userdetails 实例对象
     * @return 实例对象
     */

    @PutMapping()
    public R update(String token, Userdetails userdetails){
     return this.userdetailsService.update(token,userdetails);
    }

    @PostMapping("insertOrUpdate")
    public R insertOrUpdate(String token, @RequestBody Userdetails userdetails){
        return this.userdetailsService.insertOrUpdate(token, userdetails);
    }

}