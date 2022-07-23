package com.example.socialcontactapp.service;

import com.example.socialcontactapp.entity.User;
import com.example.socialcontactapp.utils.R;

import java.util.List;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2022-06-16 08:11:57
 */
public interface UserService {

    R loginByTel(String tel);

    R getCode(String tel);

    R loginByTel(String tel, String code);

    R loginByPassword(String password, String tel);

    R register(String tel, String invitationCode, String password,String code);
}