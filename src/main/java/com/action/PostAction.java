package com.action;

import com.pojo.Account;
import com.pojo.Comment;
import com.pojo.PageBean;
import com.pojo.Post;
import com.service.PostService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by zhanzhicheng on 2017/9/28.
 */
public class PostAction extends  ActionSupport implements ModelDriven<Post> {
    private Post post = new Post();
    private Integer currPage = 1;
    private String content;
    private File file;
    private String fileFileName;
    private String keyword;
    private String category;
    public void setCurrPage(Integer currPage) {
        this.currPage = currPage;
    }
    //注入EmployService
    private PostService postService;
    @Override
    public Post getModel() {
        return post;
    }

    public Post getPost() {
        return post;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public void setPost(Post post) {
        this.post = post;
    }

    public Integer getCurrPage() {
        return currPage;
    }

    public PostService getPostService() {
        return postService;
    }

    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String findAll() throws UnsupportedEncodingException {
            String type = ServletActionContext.getRequest().getParameter("type");
            if(type==null){
                type = "all";
                PageBean<Post> pageBean = postService.findByPage(currPage,type);
                // 将pageBean存入到值栈中
                ActionContext.getContext().getValueStack().push(pageBean);
                return "findAll";
            }
            else if(type.equals("all")||type.equals("study")||type.equals("friend"))
            {
                PageBean<Post> pageBean = postService.findByPage(currPage,type);
                // 将pageBean存入到值栈中
                ActionContext.getContext().getValueStack().push(pageBean);
                return "findAll";
            }
            else
            {   System.out.println(type);
                return  findByKeyword();
            }


    }
    //打开帖子页面
    public String postPage() {
        int id = Integer.parseInt(ServletActionContext.getRequest().getParameter("id"));
        System.out.print(id);
        Post currentPost=postService.findById(id);
        PageBean<Comment> pageBean = postService.findCommentsById(currPage,id);
        // 将pageBean存入到值栈中
        ActionContext.getContext().getValueStack().push(pageBean);
        ActionContext.getContext().put("currentPost",currentPost);
        String path="";
        if(currentPost.getResource()!=null)
            path=currentPost.getResource().getPath();
        fileFileName=path.substring(path.lastIndexOf("\\")+1,path.length());
        return "postPage";
    }

    public String findByTitle()
    {

        List<Post> postList=postService.findByTitle(post.getTitle());
        ActionContext.getContext().getValueStack().set("postList", postList);
        return "findResultByTitle";
    }
    public String save()
    {
        Account ac=(Account)ActionContext.getContext().getSession().get("existaccount") ;
        post.setPoster(ac);

        String mes=postService.savePost(post,file,fileFileName);
            // 1正常 2 开心 3难过
        PageBean<Post> pageBean = postService.findByPage(currPage,"all");
        // 将pageBean存入到值栈中
        ActionContext.getContext().getValueStack().push(pageBean);
        ServletActionContext.getRequest().setAttribute("tipMessage",mes);
        return "savesucess";
    }
    public String findByPoster(){
        String type = ServletActionContext.getRequest().getParameter("type");
        System.out.print(type);
        if (type==null) {//初始化为study页面
            type = "study";
        }
        PageBean<Post> pageBean = postService.findByPage(currPage,type);
        // 将pageBean存入到值栈中
        System.out.println(pageBean.getList().size());
        ActionContext.getContext().getValueStack().push(pageBean);
        return "findByPoster";
    }
    public String deletePost(){
        postService.deletePost(post);
        return "deleteSuccess";
    }
    public String findByKeyword() throws UnsupportedEncodingException {
        PageBean<Post> pageBean;
         String type=ServletActionContext.getRequest().getParameter("type");
        if (type==null) {
            pageBean = postService.findByPageAndKeyword(currPage, keyword);
            pageBean.setType(keyword);
        }
        else {
            type = new String(type.getBytes("ISO-8859-1"),"UTF-8");
            System.out.println(type);
            pageBean = postService.findByPageAndKeyword(currPage, type);
            pageBean.setType(type);
        }
        ActionContext.getContext().getValueStack().push(pageBean);
        return "findByKeyword";
    }

}
