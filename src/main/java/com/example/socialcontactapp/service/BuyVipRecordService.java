package com.example.socialcontactapp.service;

import com.example.socialcontactapp.utils.R;

/**
 * (BuyVipRecorder)表服务接口
 *
 * @author makejava
 * @since 2022-06-17 09:35:23
 */
public interface BuyVipRecordService {


    /**
     * 新增数据
     *
     * @return 实例对象
     */



    R insert(String token, Integer typeId );

    R queryByUserId(String token, int offset);
}