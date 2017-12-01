package com.service;

import com.pojo.User;

/**
 * Created by zhanzhicheng on 11/27/2017.
 */
public interface UserService {
    boolean authorize(String account, String password, String type);
    User getUser(int id, String type);
}
