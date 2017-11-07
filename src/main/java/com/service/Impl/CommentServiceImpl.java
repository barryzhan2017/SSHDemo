package com.service.Impl;

import com.dao.CommentDao;
import com.dao.PostDao;
import com.pojo.Comment;
import com.pojo.PageBean;
import com.pojo.Post;
import com.service.CommentService;

import java.util.Date;

public class CommentServiceImpl implements CommentService {
    CommentDao commentDao;
    PostDao postDao;
    int pageSize = 4;//回复回复的个数
    public CommentDao getCommentDao() {
        return commentDao;
    }

    public void setCommentDao(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    public PostDao getPostDao() {
        return postDao;
    }

    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }

    @Override
    public boolean saveComment(Comment comment, int pid, int cid) {
        comment.setTime(new Date());
        //2种方法不知道哪种，1-- comment直接保存，2 利用post/comment 然后update更新
        //方法1
        if(pid!=0)
        {
            //找到post,给个0 id的comment
            Post p= new Post();
            p.setId(pid);
            comment.setTargetPost(p);
        }
        else
        {
            Comment c=new Comment();
            c.setId(cid);
            comment.setTargetComment(c);
        }
        if(commentDao.save(comment))
            return true;
        else
            return  false;
    }

    @Override
    public PageBean<Comment> findCommentsById(int cid) {
        Comment comment = commentDao.findCommentsById(cid);
        if (comment==null) return null;
        System.out.print("content: "+comment.getContent()+"!");
        System.out.print("size:"+comment.getComments().size()+"!");
        PageBean<Comment> pageBean = new PageBean<Comment>();
        // 设置当前页数
        // 设置每页显示记录数
        pageBean.setPageSize(pageSize);
        // 设置总记录数
//        int totalCount = postDao.findCount();
        int totalCount = comment.getComments().size();
        pageBean.setTotalCount(totalCount);
        // 设置总页数
        double tc = totalCount;
        Double num = Math.ceil(tc / pageSize);
        pageBean.setTotalPage(num.intValue());
        // 设置每页显示的数据
        pageBean.setList(comment.getComments());
        return pageBean;
    }

}
