package com.service.Impl;

import com.dao.AccountDao;
import com.dao.AdminDao;
import com.dao.PostDao;
import com.pojo.*;
import com.service.AdminService;
import com.pojo.*;

import java.util.ArrayList;
import java.util.List;

public class AdminServiceImpl implements AdminService {
     AdminDao adminDao;
     PostDao postDao;
     AccountDao accountDao;
    private final int pageSize = 6;
    private final int commentNum = 6;
    public AdminDao getAdminDao() {
        return adminDao;
    }
    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    public PostDao getPostDao() {
        return postDao;
    }

    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public Administrator login(Administrator administrator) {
       return adminDao.login(administrator);
    }

    @Override
    public PageBean<Account> findAllUserByPage(int currentPage) {

        PageBean<Account> pageBean = new PageBean<Account>();
        // 设置当前页数
        pageBean.setCurrPage(currentPage);
        // 设置每页显示记录数
        pageBean.setPageSize(pageSize);
        // 设置总记录数
        int totalCount =accountDao.findCountAllUserPage();
        pageBean.setTotalCount(totalCount);
        // 设置总页数
        double tc = totalCount;
        Double num = Math.ceil(tc / pageSize);
        pageBean.setTotalPage(num.intValue());
        // 设置每页显示的数据
        int begin = (currentPage - 1) * pageSize;
        List<Account> list = accountDao.findByPage(begin,pageSize);
        pageBean.setList(list);
        return pageBean;

    }

    @Override
    public PageBean<Account> findUserByNameAndPage(int currentPage, String name) {
        PageBean<Account> pageBean = new PageBean<Account>();
        // 设置当前页数
        pageBean.setCurrPage(currentPage);
        // 设置每页显示记录数
        pageBean.setPageSize(pageSize);
        // 设置总记录数
        int totalCount =accountDao.findCountUserByNameAndPage(name);
        pageBean.setTotalCount(totalCount);
        // 设置总页数
        double tc = totalCount;
        Double num = Math.ceil(tc / pageSize);
        pageBean.setTotalPage(num.intValue());
        // 设置每页显示的数据
        int begin = (currentPage - 1) * pageSize;
       // List<Account> list = accountDao.f
       List<Account> list = accountDao.findUserByNameAndPage(begin,pageSize,name);
        pageBean.setList(list);
        return pageBean;
    }

    @Override
    public PageBean<Account> findUserById(int currentPage,int id) {
        PageBean<Account> pageBean = new PageBean<Account>();
        // 设置当前页数
        pageBean.setCurrPage(currentPage);
        // 设置每页显示记录数
        pageBean.setPageSize(pageSize);
        // 设置总记录数
        int totalCount =1;
        pageBean.setTotalCount(totalCount);
        // 设置总页数
        double tc = totalCount;
        Double num = Math.ceil(tc / pageSize);
        pageBean.setTotalPage(num.intValue());
        // 设置每页显示的数据
        int begin = (currentPage - 1) * pageSize;
        List<Account> list = new ArrayList<Account>();
        list.add(accountDao.findById(id));

        pageBean.setList(list);
        return pageBean;
    }

    @Override
    public PageBean<Post> findPostByKeyWordAndPage(int currentPage, String keyWord) {

        PageBean<Post> pageBean = new PageBean<Post>();
        // 设置当前页数
        pageBean.setCurrPage(currentPage);
        // 设置每页显示记录数
        pageBean.setPageSize(pageSize);
        // 设置总记录数
        if(keyWord==null){
            pageBean.setTotalCount(0);
            // 设置总页数
            Double num = Math.ceil(0 / pageSize);
            pageBean.setTotalPage(num.intValue());
            // 设置每页显示的数据
            int begin = (currentPage - 1) * pageSize;
            List<Post> list = new ArrayList<Post>();
            pageBean.setList(list);
        }
        else
        {
            int totalCount =postDao.findCountByPageAndKeyword(keyWord);
            pageBean.setTotalCount(totalCount);
            // 设置总页数
            double tc = totalCount;
            Double num = Math.ceil(tc / pageSize);
            pageBean.setTotalPage(num.intValue());
            // 设置每页显示的数据
            int begin = (currentPage - 1) * pageSize;
            List<Post> list = postDao.findByPageAndKeyword(begin,pageSize,keyWord);
            pageBean.setList(list);
        }
        return pageBean;
    }

    @Override
    public Post findPostById(int id) {
       return  postDao.findPostById(id);
    }

    @Override
    public PageBean<Comment> findCommentsById(int currentPage, int id) {
        PageBean<Comment> pageBean = new PageBean<Comment>();
        // 设置当前页数
        pageBean.setCurrPage(currentPage);
        // 设置每页显示记录数
        pageBean.setPageSize(pageSize);
        // 设置总记录数
        int totalCount =postDao.findCommentsCountById(id);
        pageBean.setTotalCount(totalCount);
        // 设置总页数
        double tc = totalCount;
        Double num = Math.ceil(tc / pageSize);
        pageBean.setTotalPage(num.intValue());
        // 设置每页显示的数据
        int begin = (currentPage - 1) * pageSize;
        List<Comment> list = postDao.findCommentsById(begin,pageSize,id);
        pageBean.setList(list);
        return pageBean;
    }

    @Override
    public void deleteAccount(int id) {
        Account ac=new Account();
        ac.setId(id);
       accountDao.delete(ac);
    }

    @Override
    public void deletePost(int id) {
        Post post=new Post();
        post.setId(id);
       postDao.deletePost(post);
    }

    @Override
    public Account findUserById(int id) {
       return accountDao.findById(id);
    }

    @Override
    public PageBean<Post> findByPageAndPosterId(int currPage, int id) {
        PageBean<Post> pageBean = new PageBean<Post>();
        // 设置当前页数
        pageBean.setCurrPage(currPage);
        // 设置每页显示记录数
        pageBean.setPageSize(pageSize);
        // 设置总记录数
        int totalCount =postDao.findPostCountByPosterId(id);
        pageBean.setTotalCount(totalCount);
        // 设置总页数
        double tc = totalCount;
        Double num = Math.ceil(tc / pageSize);
        pageBean.setTotalPage(num.intValue());
        // 设置每页显示的数据
        int begin = (currPage - 1) * pageSize;
        List<Post> list = postDao.findPostByPosterIdAndPage(begin,pageSize,id);
        pageBean.setList(list);
        return pageBean;
    }

    @Override
    public PageBean<Post> findPostByPage(int currPage) {
            PageBean<Post> pageBean = new PageBean<Post>();
            // 设置当前页数
            pageBean.setCurrPage(currPage);
            // 设置每页显示记录数
            pageBean.setPageSize(pageSize);
            // 设置总记录数
            int totalCount =postDao.findCount();
            pageBean.setTotalCount(totalCount);
            pageBean.setType("all");
            // 设置总页数
            double tc = totalCount;
            Double num = Math.ceil(tc / pageSize);
            pageBean.setTotalPage(num.intValue());
            // 设置每页显示的数据
            int begin = (currPage - 1) * pageSize;
            List<Post> list =postDao.findByPage(begin,pageSize);
            pageBean.setList(list);
            return pageBean;
        }

}
