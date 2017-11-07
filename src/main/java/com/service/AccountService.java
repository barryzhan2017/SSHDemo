package com.service;

import com.pojo.Account;

import java.io.File;
import java.io.InputStream;

public interface AccountService {
    Account login(Account account);

    void register(Account account, File headPortrait);
    Account findById(Integer eid);
    void update(Account account, File headPortrait);
    InputStream getInputSream(File file);
    InputStream getInputStream(Account account);

}
