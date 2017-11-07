package com.dao.Impl;

import com.dao.AdminDao;
import com.pojo.Administrator;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class AdminDaoImp extends HibernateDaoSupport implements AdminDao {

    public Administrator login(Administrator administrator) {
        HibernateTemplate hibernateTemplate = getHibernateTemplate();
        Administrator storedAdministrator = hibernateTemplate.get(Administrator.class, administrator.getId());
        if (storedAdministrator != null && !storedAdministrator.getPassword().equals(administrator.getPassword())) {
            storedAdministrator = null;
        }
        return storedAdministrator;
    }

}
