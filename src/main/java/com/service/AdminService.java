package com.service;

import com.pojo.*;
import com.pojo.*;

public interface AdminService {
    Administrator login(Administrator administrator);
    PageBean<Account> findAllUserByPage(int currentPage);
    PageBean<Account> findUserByNameAndPage(int currentPage, String name);
    PageBean<Account> findUserById(int currentPage, int id);
    Account  findUserById(int id);
    PageBean<Post> findPostByKeyWordAndPage(int currentPage, String keyWord);
    PageBean<Comment> findCommentsById(int currentPage, int id);
    PageBean<Post> findByPageAndPosterId(int currPage, int id);
    Post findPostById(int id);
    void deleteAccount(int id);
    void deletePost(int id);
    PageBean<Post> findPostByPage(int currPage);
}
