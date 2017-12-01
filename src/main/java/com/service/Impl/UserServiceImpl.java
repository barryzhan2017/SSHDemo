package com.service.Impl;

import com.dao.UserDao;
import com.opensymphony.xwork2.ActionContext;
import com.pojo.User;
import com.service.UserService;

import java.util.Map;

/**
 * Created by zhanzhicheng on 11/27/2017.
 */
public class UserServiceImpl implements UserService{
    UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean authorize(String account, String password, String type) {
        int id =  userDao.authorize(account,password,type);
        if (id==-1) {
            return false;
        }
        else {
            Map session = ActionContext.getContext().getSession();
            session.put("id",id);
            session.put("type",type);
            return true;
        }
    }

    @Override
    public User getUser(int id, String type) {
        return userDao.getUser(id, type);
    }
}
