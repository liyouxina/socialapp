package com.example.socialcontactapp.controller;

import com.example.socialcontactapp.service.UserdetailsService;
import com.example.socialcontactapp.utils.R;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("people")
public class PeopleController {
    @Resource
    private UserdetailsService userdetailsService;

    @RequestMapping("/getRecommendation")
    public R getRecommendation(String token, String city, int limit, int offset) {
        return R.ok().data("list", userdetailsService.queryNear(city, offset, limit));
    }

    @RequestMapping("/search")
    public R search(String token, String content) {
        return R.ok().data("list", userdetailsService.search(content));
    }
}
