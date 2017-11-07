package com.service;

import com.pojo.Comment;
import com.pojo.PageBean;

public interface CommentService {
    boolean saveComment(Comment comment, int pid, int cid);
    PageBean<Comment> findCommentsById(int cid);

}
