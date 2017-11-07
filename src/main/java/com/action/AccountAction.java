package com.action;

import com.pojo.Account;
import com.pojo.PageBean;
import com.pojo.Post;
import com.service.AccountService;
import com.service.PostService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.InputStream;

/**
 * Created by WFS on 2017/10/2.
 * 10/8login 修改
 */
public class AccountAction extends ActionSupport implements ModelDriven<Account> {
    private Account account;
    private AccountService accountService;
    private PostService postService;
    private int currentPage=1;
    private File image;
    private String imageFileName;
    private String imageContentType;
    private InputStream inputStream;
    private String allowedTypes;
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public void setCurrPage(Integer currentPage) {
        this.currentPage = currentPage;
    }
    @Override
    public Account getModel() {
        account=new Account();
        return account;
    }
    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFilename) {
        this.imageFileName = imageFilename;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public AccountService getAccountService() {
        return accountService;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public String getAllowedTypes() {
        return allowedTypes;
    }

    public void setAllowedTypes(String allowedTypes) {
        this.allowedTypes = allowedTypes;
    }

    public String getImageContentType() {
        return imageContentType;
    }

    public void setImageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
    }

    public PostService getPostService() {
        return postService;
    }

    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    //注册
    public String login(){
        //调用Service层
        System.out.println(account.getId());
        Account existAccount=accountService.login(account);
        if(existAccount==null){
            this.addActionError("用户名或者密码错误");
            return INPUT;
        }
        else
        {
            ActionContext.getContext().getSession().put("existaccount",existAccount);
            return SUCCESS;
        }
    }
    public String register() {
        accountService.register(account,image);
        ActionContext.getContext().getSession().put("existaccount",account);
        return "success";
    }
    public String viewUserInfo() {
        System.out.println(account.getId()+"iddd");
        account=accountService.findById(account.getId());
        if(account==null)
            System.out.println("acc+null");
        ActionContext.getContext().put("user",account);
        if(postService==null)
            System.out.println("post+null");
        PageBean<Post> pageBean=postService.findByPageAndPosterId(currentPage,account.getId());
        ActionContext.getContext().getValueStack().push(pageBean);
        return "viewUserInfo";
    }
    public String showPersonalInfo(){
        Account ac=(Account)ActionContext.getContext().getSession().get("existaccount");
        PageBean<Post> pageBean=postService.findByPageAndPosterId(currentPage,ac.getId());
        ActionContext.getContext().getValueStack().push(pageBean);
        return "showInfo";
    }
    //xiugai modify
    public String modify(){
        Account ac=(Account)ActionContext.getContext().getSession().get("existaccount");
        ActionContext.getContext().getSession().remove("existaccount");
        account.setId(ac.getId());
        account.setPassword(ac.getPassword());
        if(account.getBirthday()==null)
        {
            account.setBirthday(ac.getBirthday());
        }
        if(image==null)//没传照片
        {   account.setPortrait(ac.getPortrait());
            accountService.update(account,image);
            ActionContext.getContext().getSession().put("existaccount",account);
            ServletActionContext.getRequest().setAttribute("tipMessage","修改成功");
        }
        else
        {
            if(!filterType(getImageContentType())) {
                ServletActionContext.getRequest().setAttribute("tipMessage", "头像不符合标准，修改失败");
                ActionContext.getContext().getSession().put("existaccount",ac);
            }
            else
            {
                accountService.update(account,image);
                ActionContext.getContext().getSession().put("existaccount",account);
                ServletActionContext.getRequest().setAttribute("tipMessage","修改成功");
            }
        }
        return "modifyInfo";
    }
    public boolean filterType(String fileType)
    {  String[] allowed=getAllowedTypes().split(",");
        System.out.println("1111"+fileType);
        for(String type:allowed)
        {
            System.out.println(type);
            if(fileType.equals(type))
                return true;
        }
        return false;
    }
    public String readPersonalImg()
    {
        Account ac=(Account)ActionContext.getContext().getSession().get("existaccount");
        inputStream=accountService.getInputStream(ac);
        return "readPersonalImg";
    }
    public String readUserImg(){
        Account ac=accountService.findById(account.getId());
        inputStream=accountService.getInputStream(ac);
        return "readUserImg";
    }
}