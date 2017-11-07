package com.service.Impl;


import com.dao.PostDao;
import com.pojo.*;
import com.service.PostService;
import com.pojo.Comment;
import com.pojo.PageBean;
import com.pojo.Post;
import com.pojo.Resource;
import com.qcloud.Module.Wenzhi;
import com.qcloud.QcloudApiModuleCenter;
import com.qcloud.Utilities.Json.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.aspectj.util.FileUtil;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import java.util.List;
import java.util.TreeMap;


public class PostServiceImpl implements PostService {

    private PostDao postDao;
    private final int pageSize = 3;
    private final int commentNum = 6;

    public PostDao getPostDao() {
        return postDao;
    }

    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }

    public int getCommentNum() {
        return commentNum;
    }

    @Override
    public PageBean<Post> findByPage(Integer currPage, String type) {
        PageBean<Post> pageBean = new PageBean<Post>();
        // 设置当前页数
        pageBean.setCurrPage(currPage);
        // 设置每页显示记录数
        pageBean.setPageSize(pageSize);
        pageBean.setType(type);
        // 设置总记录数
//        int totalCount = postDao.findCount();
        int totalCount;
        if (type.equals("all")) {
            totalCount = postDao.findCount();
        }
        else {
            totalCount = postDao.findCountByType(type);
        }
        pageBean.setTotalCount(totalCount);
        // 设置总页数
        double tc = totalCount;
        Double num = Math.ceil(tc / pageSize);
        pageBean.setTotalPage(num.intValue());
        // 设置每页显示的数据
        int begin = (currPage - 1) * pageSize;
        List<Post> list;
        if (type.equals("all")) {
           list = postDao.findByPage(begin,pageSize);
        }
        else {
           list = postDao.findByPageAndType(begin, pageSize, type);
        }
        pageBean.setList(list);
        return pageBean;
    }

    @Override
    public PageBean<Comment> findCommentsById(Integer currPage, int id) {
        PageBean<Comment> pageBean = new PageBean<Comment>();
        // 设置当前页数
        pageBean.setCurrPage(currPage);
        // 设置每页显示记录数
        pageBean.setPageSize(commentNum - 1);
        pageBean.setPageSize(commentNum);

        // 设置总记录数
        int totalCount = postDao.findCommentsCountById(id)+1;
        //加上帖子本身的数量
        pageBean.setTotalCount(totalCount);
        // 设置总页数
        double tc = totalCount;
        Double num = Math.ceil(tc / commentNum);
        System.out.print(num.intValue());
        pageBean.setTotalPage(num.intValue());
        // 设置每页显示的数据
        int begin = (currPage - 1) * commentNum;
        List<Comment> list;
        if (currPage==1) {//第一页回复减一
            list = postDao.findCommentsById(begin, commentNum - 1, id);
        }
        else {
            list = postDao.findCommentsById(begin-1, commentNum, id);
        }
        pageBean.setList(list);
        return pageBean;
    }

    public int judgeSentiment(Post post){
        int re=1;// normal
        String content=post.getTitle()+post.getContent();
        TreeMap<String, Object> config = new TreeMap<String, Object>();
        config.put("SecretId", "AKIDRjpvrbfdrvvoV06SUxFPN9jDXgeQbQcc");
        config.put("SecretKey", "ykdR4VntoX5eqoiQxITSFqU3gFdppdEo");
        config.put("RequestMethod", "GET");
        config.put("DefaultRegion", "gz");
        config.put("Action","TextSentiment");
        config.put("content",content);
        QcloudApiModuleCenter module = new QcloudApiModuleCenter(new Wenzhi(),config);
        TreeMap<String, Object> params = new TreeMap<String, Object>();
        params.put("content",content);
        String json = null;
        double senti=-1;
        try {
		/* call 方法正式向指定的接口名发送请求，并把请求参数params传入，返回即是接口的请求结果。 */
            json = module.call("TextSentiment", params);
            JSONObject json_result = new JSONObject(json);
            senti=Double.valueOf((Double) json_result.get("negative"));
            System.out.println(json_result);
        } catch (Exception e) {
            System.out.println("error..." + e.getMessage());
        }
      if(senti>=0.7){
            re=3;//不开心
      }
      else if(senti>0&&senti<0.3)
      {
          re=2;//开心
      }
      else
      {
          re=1;//normal
      }
      System.out.println(re);
       return re;
    }
    public int judgeSensitive(Post post){
        String content=post.getTitle()+post.getContent();
        int re=0;
        TreeMap<String, Object> config = new TreeMap<String, Object>();
        config.put("SecretId", "AKIDRjpvrbfdrvvoV06SUxFPN9jDXgeQbQcc");
        config.put("SecretKey", "ykdR4VntoX5eqoiQxITSFqU3gFdppdEo");
        config.put("RequestMethod", "GET");
        config.put("DefaultRegion", "gz");
        config.put("Action","TextSensitivity");
        QcloudApiModuleCenter module = new QcloudApiModuleCenter(new Wenzhi(),config);
        TreeMap<String, Object> params = new TreeMap<String, Object>();
        params.put("content",content);
        params.put("type",2);
        String result = null;
        double sensi=0;
        try {
		/* call 方法正式向指定的接口名发送请求，并把请求参数params传入，返回即是接口的请求结果。 */
            result = module.call("TextSensitivity", params);
            JSONObject json_result = new JSONObject(result);
            System.out.println(json_result);
            sensi=Double.valueOf((Double) json_result.get("sensitive"));
            System.out.println(json_result);
        } catch (Exception e) {
            System.out.println("error..." + e.getMessage());
        }
        if(sensi>0.7)
        {
            re=1;
        }
        return re;
    }
    @Override
    public String savePost(Post post,File file,String filename)
    {
        String re="";
        if(judgeSensitive(post)==1){
            re="信息敏感，发送失败";
            return re;
        }
        post.setTime(new Date());
        if(file!=null)
        {
            Resource resource=new Resource();
            resource.setOwner(post.getPoster());
            resource.setTime(post.getTime());
            resource.setTitle(post.getTitle());
            String rootPath= ServletActionContext.getServletContext().getRealPath("userResource");
            String target=post.getPoster().getId()+"\\"+filename;
            String targetPath=rootPath+"\\"+target;
            File saveFile=new File(targetPath);
            try {
                FileUtil.copyFile(file,saveFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            resource.setPath(target);
            post.setResource(resource);
        }
        postDao.savePost(post);
        int senti=judgeSentiment(post);
        System.out.println(senti);
        if(senti==1)
        {
             re="发帖成功";
        }
        else if(senti==2)
        {
            re="这么开心的么？";
        }
        else if(senti==3)
        {
            re="不要伤心，不要难过，忧郁的日子总会过去，java框架会拿高分";
        }
        else
        {
           re="";
        }
        return re;
    }

    @Override
    public Post findById(int id) {
        return postDao.findPostById(id);
    }

    public List<Post> findByTitle(String title)
    {
        return postDao.findByTitle(title);
    }
    @Override
    public PageBean<Post> findByPageAndPosterId(int currPage,int id)
    {   PageBean<Post> pageBean = new PageBean<Post>();
        // 设置当前页数
        pageBean.setCurrPage(currPage);
        // 设置每页显示记录数
        pageBean.setPageSize(pageSize);
        // 设置总记录数
        int totalCount =postDao.findPostCountByPosterId(id);
        pageBean.setTotalCount(totalCount);
        // 设置总页数
        double tc = totalCount;
        Double num = Math.ceil(tc / pageSize);
        pageBean.setTotalPage(num.intValue());
        // 设置每页显示的数据
        int begin = (currPage - 1) * pageSize;
        List<Post> list = postDao.findPostByPosterIdAndPage(begin,pageSize,id);
        pageBean.setList(list);
        return pageBean;
    }

    @Override
    public PageBean<Post> findByPageAndKeyword(int currPage, String keyword) {
        PageBean<Post> pageBean = new PageBean<Post>();
        // 设置当前页数
        pageBean.setCurrPage(currPage);
        // 设置每页显示记录数
        pageBean.setPageSize(pageSize);
        // 设置总记录数
        int totalCount =postDao.findCountByPageAndKeyword(keyword);
        pageBean.setTotalCount(totalCount);
        // 设置总页数
        double tc = totalCount;
        Double num = Math.ceil(tc / pageSize);
        pageBean.setTotalPage(num.intValue());
        // 设置每页显示的数据
        int begin = (currPage - 1) * pageSize;
        List<Post> list = postDao.findByPageAndKeyword(begin,pageSize,keyword);
        pageBean.setList(list);
        return pageBean;
    }

    public int getPageSize() {
        return pageSize;
    }

    @Override
    public boolean deletePost(Post post) {
        postDao.deletePost(post);
        return true;
    }
}
