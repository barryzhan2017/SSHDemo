package com.dao.Impl;

import com.dao.CommentDao;
import com.pojo.Comment;
import com.pojo.Post;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class CommentDaoImpl extends HibernateDaoSupport implements CommentDao {
    public boolean save(Comment comment) {
        Session session = getHibernateTemplate().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        if (comment.getTargetPost() != null) {
            Post targetPost = session.get(Post.class, comment.getTargetPost().getId());
            targetPost.getComments().add(comment);
        }
        else {
            Comment targetComment = session.get(Comment.class,comment.getTargetComment().getId());
            targetComment.getComments().add(comment);
        }
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Comment findCommentsById(int cid) {
        Comment comment = getHibernateTemplate().get(Comment.class, cid);
        return comment;
    }

    @Override
    public List<Comment> findCommentsByIdAndPage(int begin, int pageSize, int id) {
        Session session = getHibernateTemplate().getSessionFactory().openSession();
        String hql = "from Commenet comment where comment.targetComment.id = ?";
        Query query = session.createQuery(hql);
        query.setInteger(0, id);
        query.setFirstResult(begin);
        query.setMaxResults(pageSize);
        List<Comment> comments = query.list();
        session.close();
        return comments;
    }


}
