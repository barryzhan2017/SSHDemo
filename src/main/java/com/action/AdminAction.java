package com.action;

import com.pojo.*;
import com.service.AdminService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.pojo.*;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.ParentPackage;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

@ParentPackage("json-default")
//@Namespace("/comment")
public class AdminAction extends ActionSupport implements ModelDriven<Administrator> {
    private Administrator administrator=new Administrator();
    private AdminService adminService;
    private Integer currPage = 1;
    private String category;
    private String type;
    private File file;
    private String fileFileName;
    private int fid;
    private int uid=0;
    private String keyword;

    public Administrator getAdministrator() {
        return administrator;
    }

    public AdminService getAdminService() {
        return adminService;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    public Integer getCurrPage() {
        return currPage;
    }

    public void setCurrPage(Integer currPage) {
        this.currPage = currPage;
    }

    public Administrator getModel() {
        return administrator;
    }

    public String getCategory() {
        return category;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String findU() throws UnsupportedEncodingException {
        if(category==null)
        {
            return findAllUser();
        }
        if(category.equals("findAllUser"))
        {
            return findAllUser();
        }
        else if(category.equals("findUserByNameAndPage"))
        {
            return findUserByNameAndPage();
        }
        else if(category.equals("findUserById"))
        {
            return findUserById();
        }
        else
        {
            return findAllUser();
        }
    }
    public String findP() throws UnsupportedEncodingException {
        if(category==null)
        {
           return findAllPost();
        }
        else if(category.equals("findPostByKeyWord"))
        {
            return findPostByKeyWord();
        }
        else
        {
            return findAllPost();
        }
    }
    public String login(){
        Administrator existAdministrator=adminService.login(administrator);
        if(existAdministrator==null){
            this.addActionError("用户名或者密码错误");
            return INPUT;
        }
        else
        {
            ActionContext.getContext().getSession().put("administrator",existAdministrator);
            return SUCCESS;
        }
    }
    public String findAllUser(){

         PageBean<Account> pageBean= adminService.findAllUserByPage(currPage);
         ActionContext.getContext().getValueStack().push(pageBean);
         ServletActionContext.getRequest().setAttribute("category",category);
         return "findAllUser";
    }
    public String findAllPost(){
      PageBean<Post> pageBean = adminService.findPostByPage(currPage);
      ActionContext.getContext().getValueStack().push(pageBean);
      ServletActionContext.getRequest().setAttribute("category","");
      return "findAllPost";

    }
    public String findUserByNameAndPage() throws UnsupportedEncodingException {
        PageBean<Account> pageBean;
        if(keyword==null)
        {
            type=new String(type.getBytes("ISO-8859-1"),"UTF-8");
            pageBean= adminService.findUserByNameAndPage(currPage,type);
            pageBean.setType(type);
        }
        else
        {
            pageBean= adminService.findUserByNameAndPage(currPage,keyword);
            pageBean.setType(keyword);
        }
        ActionContext.getContext().getValueStack().push(pageBean);
        ServletActionContext.getRequest().setAttribute("category",category);
        return "findUserByNameAndPage";
    }
    public String findUserById(){
        PageBean<Account> pageBean;
        if(keyword=="")
        {
             pageBean=new PageBean<Account>();
             pageBean.setList(new ArrayList<Account>()) ;
        }
        else
        {
            int userid=Integer.parseInt(keyword);
            pageBean=adminService.findUserById(currPage,userid);
        }
        ActionContext.getContext().getValueStack().push(pageBean);
        ServletActionContext.getRequest().setAttribute("category",category);
        return "findUserByid";
    }
    public String findPostByKeyWord() throws UnsupportedEncodingException {
        PageBean<Post> pageBean;
        if(keyword==null){
             category = new String(category.getBytes("ISO-8859-1"),"UTF-8");
             pageBean=adminService.findPostByKeyWordAndPage(currPage,category);
             ServletActionContext.getRequest().setAttribute("category",category);
        }
        else {
            pageBean=adminService.findPostByKeyWordAndPage(currPage,keyword);
            ServletActionContext.getRequest().setAttribute("category",keyword);
        }
        ActionContext.getContext().getValueStack().push(pageBean);

        return "findPostByKeyWord";
    }
    public String deletePostU(){
        adminService.deletePost(fid);
        ServletActionContext.getRequest().setAttribute("tipMessage","删除成功");
        Account account=adminService.findUserById(uid);
        if(account==null)
            System.out.println("acc+null");
        ActionContext.getContext().put("user",account);
        PageBean<Post> pageBean=adminService.findByPageAndPosterId(currPage,uid);
        ActionContext.getContext().getValueStack().push(pageBean);
        return "viewUserInfo";
    }
    public String deletePost(){
        System.out.println(fid);
        adminService.deletePost(fid);
        ServletActionContext.getRequest().setAttribute("tipMessage","删除成功");
        ServletActionContext.getRequest().setAttribute("category",category);
        PageBean<Post> pageBean = adminService.findPostByPage(currPage);
        ActionContext.getContext().getValueStack().push(pageBean);
        if(uid!=0){
            return viewUserPage();
        }
        return "deletePost";
    }
    public String deleteAccount(){
        adminService.deleteAccount(fid);
        ServletActionContext.getRequest().setAttribute("tipMessage","删除成功");
        PageBean<Account> pageBean= adminService.findAllUserByPage(currPage);
        ActionContext.getContext().getValueStack().push(pageBean);
        ServletActionContext.getRequest().setAttribute("category",category);
        return "findAllUser";
    }
    public String viewUserPage(){
        int id = Integer.parseInt(ServletActionContext.getRequest().getParameter("uid"));
        Account account=adminService.findUserById(id);
        if(account==null)
            System.out.println("acc+null");
        ActionContext.getContext().put("user",account);
        PageBean<Post> pageBean=adminService.findByPageAndPosterId(currPage,id);
        ActionContext.getContext().getValueStack().push(pageBean);
        ServletActionContext.getRequest().setAttribute("uid",uid);
        return "viewUserInfo";
    }
    public String viewPostPage(){
        int id = Integer.parseInt(ServletActionContext.getRequest().getParameter("fid"));
        Post currentPost=adminService.findPostById(id);
        PageBean<Comment> pageBean = adminService.findCommentsById(currPage,id);
        // 将pageBean存入到值栈中
        ActionContext.getContext().getValueStack().push(pageBean);
        ActionContext.getContext().put("currentPost",currentPost);
        ServletActionContext.getRequest().setAttribute("uid",uid);
        String path="";
        if(currentPost.getResource()!=null)
            path=currentPost.getResource().getPath();
        fileFileName=path.substring(path.lastIndexOf("\\")+1,path.length());
        return "viewPostPage";
    }


}
