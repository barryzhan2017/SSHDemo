package com.dao.Impl;

import com.dao.PostDao;
import com.pojo.Comment;
import com.pojo.Post;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class PostDaoImpl extends HibernateDaoSupport implements PostDao {
    @Override

        public void deletePost(Post post) {
            Session session = getHibernateTemplate().getSessionFactory().openSession();
            String hql = "delete from Post post where post.id = ?";
            Query query = session.createQuery(hql);
            query.setInteger(0, post.getId());
            query.executeUpdate();
            session.close();
        }

    @Override
    public Post findPostById(int id) {
        String hql = "from Post post where post.id = ?";
        List<?> list =  this.getHibernateTemplate().find(hql,id);
        if(list.size()>0)
            return (Post)list.get(0);
        else
            return null;


    }

    public int findCount() {
        Session session = getHibernateTemplate().getSessionFactory().openSession();
        String hql = "select count(*) from Post";
        Long count = (Long)session.createQuery(hql).uniqueResult();
        session.close();
        if(count==null)
            count=new Long(0);
        return count.intValue();
    }

    public List<Post> findByPageAndType(int begin, int pageSize, String type) {
        Session session = getHibernateTemplate().getSessionFactory().openSession();
        String hql = "from Post post where post.category = ? order by post.id desc";
        Query query = session.createQuery(hql);
        query.setString(0, type);
        query.setFirstResult(begin);
        query.setMaxResults(pageSize);
        List<Post> posts=query.list();
        session.close();
        return posts;
    }

    public List<Post> findByPageAndKeyword(int begin, int pageSize, String keyword) {

        Session session = getHibernateTemplate().getSessionFactory().openSession();
        String hql = "from Post post where MATCHING(post.title, ?) > 0 order by MATCHING(post.title, ?) desc";
        Query query = session.createQuery(hql);
        query.setString(0,keyword);
        query.setString(1,keyword);
        query.setFirstResult(begin);
        query.setMaxResults(pageSize);
        List<Post> posts = query.list();
        session.close();
        return posts;
    }

    public List<Post> findByPage(int begin, int pageSize) {
        Session session = getHibernateTemplate().getSessionFactory().openSession();
        Query query = session.createQuery("from Post post order by post.id desc");
        query.setFirstResult(begin);
        query.setMaxResults(pageSize);
        List<Post> posts=query.list();
        session.close();
        return posts;
    }

    public List<Post> findByTitle(String title) {
        Session session = getHibernateTemplate().getSessionFactory().openSession();
        String hql="from Post post where post.title = ? order by post.id desc";
        Query query = session.createQuery(hql);
        query.setString(0, title);
        List<Post> posts = query.list();
        session.close();
        return posts;
    }

    public void savePost(Post post) {
        getHibernateTemplate().save(post);
    }

    public int findCountByType(String type) {
        Session session = getHibernateTemplate().getSessionFactory().openSession();
        String hql = "select count(*) from Post post where post.category = ?";
        Query query = session.createQuery(hql);
        query.setString(0,type);
        Long count = (Long) query.uniqueResult();
        session.close();
        if(count==null)
            count=new Long(0);
        return count.intValue();
    }

    public int findCommentsCountById(int id) {
        Session session = getHibernateTemplate().getSessionFactory().openSession();
        String hql = "select count(*) from Comment comment where comment.targetPost.id = ?";
        Query query = session.createQuery(hql);
        query.setInteger(0,id);
        Long count = (Long) query.uniqueResult();
        session.close();
        if(count==null)
            count=new Long(0);
        return count.intValue();
    }

    public List<Comment> findCommentsById(int begin, int pageSize, int id) {
        Session session = getHibernateTemplate().getSessionFactory().openSession();
        String hql = "from Comment comment where comment.targetPost.id = ? order by comment.id asc";
        Query query = session.createQuery(hql);
        query.setInteger(0,id);
        query.setFirstResult(begin);
        query.setMaxResults(pageSize);
        List<Comment> comments = query.list();
        session.close();
        return comments;
    }

    public List getListByHql(String hql) {
        List list = getHibernateTemplate().find(hql);
        return list;
    }

    @Override
    public int findPostCountByPosterId(int id) {
        Session session = getHibernateTemplate().getSessionFactory().openSession();
        String hql = "select count(*) from Post post where post.poster.id = ?";
        Query query = session.createQuery(hql);
        query.setInteger(0, id);
        Long count = (Long) query.uniqueResult();
        if (count ==null) {
            count = new Long(0);
        }
        session.close();
        return count.intValue();

    }

    @Override
    public List<Post> findPostByPosterIdAndPage(int begin, int pageSize, int id) {
        Session session = getHibernateTemplate().getSessionFactory().openSession();
        String hql = "from Post post where post.poster.id = ? order by post.id desc";
        Query query = session.createQuery(hql);
        query.setInteger(0, id);
        query.setFirstResult(begin);
        query.setMaxResults(pageSize);
        List<Post> posts = query.list();
        session.close();
        return posts;

    }
    public int findCountByPageAndKeyword(String keyword) {
        Session session = getHibernateTemplate().getSessionFactory().openSession();
        String hql = "select count(*) from Post post where MATCHING(post.title, ?) > 0";
        Query query = session.createQuery(hql);
        query.setString(0, keyword);
        Long count = (Long) query.uniqueResult();
        if (count == null) {
            count = new Long(0);
        }
        session.close();
        return count.intValue();
    }

}