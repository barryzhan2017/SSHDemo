package com.dao;

import com.pojo.Account;

import java.util.List;

public interface AccountDao {
    Account findUserByIdAndPassword(Account account);
    void update(Account account);
    void register(Account account);
    Account findById(int id);
    void delete(Account account);
    List<Account> findByPage(int begin, int pageSize);


    int findCountAllUserPage();

    int findCountUserByNameAndPage(String name);

    List<Account> findUserByNameAndPage(int begin, int pageSize, String name);
}