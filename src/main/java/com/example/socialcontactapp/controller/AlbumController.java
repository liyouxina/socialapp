package com.example.socialcontactapp.controller;

import com.example.socialcontactapp.entity.Album;
import com.example.socialcontactapp.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Album)表控制层
 *
 * @author makejava
 * @since 2022-06-16 08:11:55
 */
@RestController
@RequestMapping("album")
public class AlbumController {
    /**
     * 服务对象
     */
    @Autowired
    private AlbumService albumService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Album selectOne(Integer id) {
        return this.albumService.queryById(id);
    }
    @GetMapping("query")
    public Album query(Integer userId){
    return null;
    }
}