package com.service;

import com.pojo.Comment;
import com.pojo.PageBean;
import com.pojo.Post;

import java.io.File;
import java.util.List;

/**
 * Created by zhanzhicheng on 2017/9/28.
 */
public interface PostService {

    PageBean<Post> findByPage(Integer currPage, String type);
    List<Post> findByTitle(String title);
    PageBean<Comment> findCommentsById(Integer currPage, int id);
    String savePost(Post post, File file, String filename);
    Post findById(int id);

    PageBean<Post> findByPageAndPosterId(int currPage, int id);

    PageBean<Post> findByPageAndKeyword(int currPage, String keyword);

    boolean deletePost(Post post);
}
