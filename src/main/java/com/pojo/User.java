package com.pojo;

/**
 * Created by zhanzhicheng on 11/5/2017.
 */
public abstract class User {
    private String account;
    private String password;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public abstract boolean validate(String account,String password);
}