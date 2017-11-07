package com.pojo;



import java.util.Date;
import java.util.List;

public class Comment {

    private Integer id;
    private Post targetPost;
    private Comment targetComment;
    private Account author;
    private Date time;
    private String content;
    private List<Comment> comments;

    public Comment() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Post getTargetPost() {
        return targetPost;
    }

    public void setTargetPost(Post targetPost) {
        this.targetPost = targetPost;
    }

    public Comment getTargetComment() {
        return targetComment;
    }

    public void setTargetComment(Comment targetComment) {
        this.targetComment = targetComment;
    }

    public Account getAuthor() {
        return author;
    }

    public void setAuthor(Account author) {
        this.author = author;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

}
