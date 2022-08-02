package com.example.socialcontactapp.service;

import com.example.socialcontactapp.entity.Dynamicmessage;
import com.example.socialcontactapp.utils.R;

import java.util.List;

/**
 * (Dynamicmessage)表服务接口
 *
 * @author makejava
 * @since 2022-06-16 08:11:57
 */
public interface DynamicmessageService {

    /**
     * 修改数据
     *
     * @param dynamicmessage 实例对象
     * @return 实例对象
     */
    R update(Dynamicmessage dynamicmessage,String token);


    R deleteById( String token,Integer messageid);


    R publishDynamics(String token, String label, String address, Integer nums, String topic, String pictures, String content);

    R queryByUserId(String token, int offset);

    R addLove(String token, int messageId);
}