package com.dao;

import com.pojo.Comment;

import java.util.List;

public interface CommentDao {
    // save
    boolean save(Comment comment);
    Comment findCommentsById(int cid);
    List<Comment> findCommentsByIdAndPage(int begin, int pageSize, int id);
}
