package com.dao;

import com.pojo.User;

/**
 * Created by zhanzhicheng on 11/27/2017.
 */
public interface UserDao {
    int authorize(String account, String password, String type);
    User getUser(int id, String type);
}
