package com.dao;

import com.pojo.Comment;
import com.pojo.Post;

import java.util.List;

public interface PostDao {

    int findCount();
    List<Post> findByPageAndType(int begin, int pageSize, String type);
    List<Post> findByPageAndKeyword(int begin, int pageSize, String keyword);
    List<Post> findByPage(int begin, int pageSize);
    List<Post> findByTitle(String title);
    void savePost(Post post);
    int findCountByType(String type);
    int findCommentsCountById(int id);
    List<Comment> findCommentsById(int begin, int pageSize, int id);
    List getListByHql(final String hql);
    List<Post> findPostByPosterIdAndPage(int begin, int pageSize, int id);
    int findPostCountByPosterId(int id);
    int findCountByPageAndKeyword(String keyword);
    void deletePost(Post post);
    Post findPostById(int id);
}
