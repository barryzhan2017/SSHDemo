package com.dao.Impl;

import com.dao.SanitaryStatusDao;
import com.pojo.SanitaryStatus;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zhanzhicheng on 11/16/2017.
 */
@Transactional

public class SanitaryStatusDaoImpl extends HibernateDaoSupport implements SanitaryStatusDao {

    @Override
    public List<SanitaryStatus> getAllSanitaryStatus(Integer id) {
        String hql = "from SanitaryStatus s where s.room.instructor.id=?";
        List<SanitaryStatus> sanitaryStatuses = (List<SanitaryStatus>)getHibernateTemplate().find(hql,id);
        if (sanitaryStatuses.isEmpty()) {
            return null;
        }
        return sanitaryStatuses;
    }

    @Override
    public boolean addSanitaryStatus(SanitaryStatus sanitaryStatus) {
        getHibernateTemplate().save(sanitaryStatus);
        return true;
    }


}
