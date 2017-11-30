package com.dao.Impl;

import com.dao.UserDao;
import com.pojo.Instructor;
import com.pojo.User;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zhanzhicheng on 11/27/2017.
 */
@Transactional
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
    @Override
    public int authorize(String account, String password, String type) {
        User user;
        String hql = "";
        if (type==null) {
            return -1;
        }
        if (type.equals("instructor")) {
            hql = "from  Instructor instructor where  instructor.account=? and instructor.password=?";
        }
        else if (type.equals("dormitoryStaff")) {
            hql = "from  DormitoryStaff ds where  ds.account=? and ds.password=?";
        }
        else if (type.equals("systemAdministrator")) {
            hql = "from  SystemAdministrator sa where  sa.account=? and sa.password=?";
        }
        else {
            return -1;
        }
        user = ((List<User>)getHibernateTemplate().find(hql,new Object[]{account,password})).get(0);
        if (user==null) {
            return -1;
        }
        return user.getId();
    }
}
