package com.action;

import com.pojo.Account;
import com.pojo.Comment;
import com.pojo.PageBean;
import com.service.CommentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import java.util.HashMap;
import java.util.Map;


@ParentPackage("json-default")
@Namespace("/comment")
public class CommentAction extends ActionSupport implements ModelDriven<Comment> {
    CommentService commentService;
    private Map<String, String> dataMap;
    String con;//comment
    int cid=0;
    int pid=0;
    Comment comment = new Comment();


    public Map<String, String> getDataMap() {
        return dataMap;
    }

    public void setDataMap(Map<String, String> dataMap) {
        this.dataMap = dataMap;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public String getCon() {

        return con;
    }

    public void setCon(String con) {
        this.con = con;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }



    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public CommentService getCommentService() {
        return commentService;
    }

    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

    @Override
    public Comment getModel() {
        return comment;
    }

    //找到回复回复
    @Action(value = "findComments", results = { @Result(type = "json", params = { "root", "dataMap" }) })
    public String findComments() throws Exception {
        this.dataMap = new HashMap<String, String>();
        String cid = ServletActionContext.getRequest().getParameter("cid");
        PageBean<Comment> commentPageBean = commentService.findCommentsById(Integer.valueOf(cid));
        dataMap.put("id",cid);
        StringBuffer sb = new StringBuffer();
        for (Comment comment: commentPageBean.getList()) {
            sb.append("<span>"+comment.getAuthor().getNickname()+"回复： "+comment.getContent()+"</span></br>");
        }
        dataMap.put("info", sb.toString());
        return "success";
    }


    @Action(value = "postComment", results = { @Result(type = "json", params = { "root", "dataMap" }) })
    public String postComment() throws Exception {
        this.dataMap = new HashMap<String, String>();
// 参数名称必须和jsp的空间名称一一对应
        int pid = 0;
        int cid = 0;
        String content = ServletActionContext.getRequest().getParameter("content");
        if (ServletActionContext.getRequest().getParameter("pid")!=null) {
            pid = Integer.valueOf(ServletActionContext.getRequest().getParameter("pid"));
        }
        if (ServletActionContext.getRequest().getParameter("cid")!=null) {
            cid = Integer.valueOf(ServletActionContext.getRequest().getParameter("cid"));
        }
        System.out.print("cid:"+cid+"pid:"+pid+"content"+content);
        Account ac=(Account) ActionContext.getContext().getSession().get("existaccount");
        comment.setAuthor(ac);
        comment.setContent(content);
        if(commentService.saveComment(comment,pid,cid)) {
            System.out.print("success");
            return "success";
        }
        else
            return "fail";
    }



}
