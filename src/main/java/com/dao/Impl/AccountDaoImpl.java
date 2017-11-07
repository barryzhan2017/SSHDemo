package com.dao.Impl;

import com.dao.AccountDao;
import com.pojo.Account;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
public class AccountDaoImpl extends HibernateDaoSupport implements AccountDao {


     @Override
    public void register(Account account) {
        getHibernateTemplate().save(account);
    }
    @Override
    public void delete(Account account) {
        getHibernateTemplate().delete(account);
    }
    @Override
    public void update(Account account) {
        getHibernateTemplate().update(account);
    }
    @Override
    public Account findById(int id) {
        Account account = getHibernateTemplate().get(Account.class, id);
        return account;
    }
    @Override
    public Account findUserByIdAndPassword(Account account) {
        HibernateTemplate hibernateTemplate = getHibernateTemplate();
        Account storedAccount = hibernateTemplate.get(Account.class, account.getId());
        if (storedAccount != null && !storedAccount.getPassword().equals(account.getPassword())) {
            storedAccount = null;
        }
        return storedAccount;
    }
    @Override
    public List<Account> findByPage(int begin, int pageSize) {
        Session session = getHibernateTemplate().getSessionFactory().openSession();
        Query query = session.createQuery("from Account account order by account.id desc");
        query.setFirstResult(begin);
        query.setMaxResults(pageSize);
        List<Account> accounts = query.list();
        session.close();
        return accounts;
    }
    public List<Account> findUserByNameAndPage(int begin, int pageSize, String name) {
        Session session = getHibernateTemplate().getSessionFactory().openSession();
        String hql = "from Account account where account.nickname like ? order by account.id desc";
        Query query = session.createQuery(hql);
        query.setString(0, "%"+name+"%");
        query.setFirstResult(begin);
        query.setMaxResults(pageSize);
        List<Account> accounts = query.list();
        if(accounts==null)
            accounts=new ArrayList<Account>();
        session.close();
        return accounts;
    }

    public int findCountAllUserPage() {
        Session session = getHibernateTemplate().getSessionFactory().openSession();
        String hql = "select count(*) from Account";
        Query query = session.createQuery(hql);
        Long count = (Long) query.uniqueResult();
        if (count == null) {
            count = new Long(0);
        }
        session.close();
        return count.intValue();
    }

    public int findCountUserByNameAndPage(String name) {
        Session session = getHibernateTemplate().getSessionFactory().openSession();
        String hql = "select count(*) from Account account where account.nickname like ?";
        Query query = session.createQuery(hql);
        query.setString(0, "%"+name+"%");
        Long count = (Long) query.uniqueResult();
        if (count == null) {
            count = new Long(0);
        }
        session.close();
        return count.intValue();
    }

}
