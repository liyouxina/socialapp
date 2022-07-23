package com.example.socialcontactapp.controller;

import com.example.socialcontactapp.dao.DynamicmessageDao;
import com.example.socialcontactapp.entity.DynamicComment;
import com.example.socialcontactapp.service.DynamicCommentService;
import com.example.socialcontactapp.utils.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (DynamicComment)表控制层
 *
 * @author makejava
 * @since 2022-06-25 18:05:37
 */
@RestController
@RequestMapping("dynamicComment")
public class DynamicCommentController {
    /**
     * 服务对象
     */
    @Resource
    private DynamicCommentService dynamicCommentService;



    @GetMapping()
    public R queryAllByLimit(Integer messageId, int offset, int limit) {
        return dynamicCommentService.queryAllByLimit(messageId, offset, limit);
    }

    @PostMapping()
    public R insert(String token, DynamicComment dynamicComment) {
        return dynamicCommentService.insert(token, dynamicComment);
    }

    @DeleteMapping()
    public R deleteById(String token, Integer messageId) {

        return dynamicCommentService.deleteById(token, messageId);

    }
}