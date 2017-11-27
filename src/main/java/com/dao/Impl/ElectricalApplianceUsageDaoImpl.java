package com.dao.Impl;

import com.dao.ElectricalApplianceUsageDao;
import com.pojo.ElectricalApplianceUsage;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by zhanzhicheng on 11/24/2017.
 */
public class ElectricalApplianceUsageDaoImpl extends HibernateDaoSupport implements ElectricalApplianceUsageDao {


    @Override
    public List<ElectricalApplianceUsage> getAllElectricalApplianceUsage(Integer id) {
        String hql = "from ElectricalApplianceUsage e where e.room.instructor.id=?";
        List<ElectricalApplianceUsage> electricalApplianceUsages = (List<ElectricalApplianceUsage>)getHibernateTemplate().find(hql,id);
        if (electricalApplianceUsages.isEmpty()) {
            return null;
        }
        return electricalApplianceUsages;

    }

    @Override
    public boolean update(String newSituation, Integer studentId) {
        String hql = "from ElectricalApplianceUsage e where e.student.id=?";
        List<ElectricalApplianceUsage> electricalApplianceUsages = (List<ElectricalApplianceUsage>)getHibernateTemplate().find(hql,studentId);
        if (electricalApplianceUsages.isEmpty())
            return false;
        else {
            ElectricalApplianceUsage electricalApplianceUsage = electricalApplianceUsages.get(0);
            electricalApplianceUsage.setSituation(newSituation);
            getHibernateTemplate().update(electricalApplianceUsage);
            return true;
        }
    }
}
