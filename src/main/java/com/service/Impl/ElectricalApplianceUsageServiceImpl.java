package com.service.Impl;

import com.dao.ElectricalApplianceUsageDao;
import com.dao.RoomDao;
import com.dao.StudentManagementDao;
import com.pojo.ElectricalApplianceUsage;
import com.pojo.Instructor;
import com.pojo.Room;
import com.pojo.Student;
import com.service.ElectricalApplianceUsageService;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;
import java.util.List;

/**
 * Created by zhanzhicheng on 11/24/2017.
 */
public class ElectricalApplianceUsageServiceImpl implements ElectricalApplianceUsageService {

    ElectricalApplianceUsageDao electricalApplianceUsageDao;
    StudentManagementDao studentManagementDao;
    public ElectricalApplianceUsageDao getElectricalApplianceUsageDao() {
        return electricalApplianceUsageDao;
    }

    public void setElectricalApplianceUsageDao(ElectricalApplianceUsageDao electricalApplianceUsageDao) {
        this.electricalApplianceUsageDao = electricalApplianceUsageDao;
    }

    public StudentManagementDao getStudentManagementDao() {
        return studentManagementDao;
    }

    public void setStudentManagementDao(StudentManagementDao studentManagementDao) {
        this.studentManagementDao = studentManagementDao;
    }

    @Override
    public List<ElectricalApplianceUsage> getAllElectricalApplianceUsage(Integer id) {
        return electricalApplianceUsageDao.getAllElectricalApplianceUsage(id);
    }

    @Override
    public boolean update(String newSituation, Integer id) {
        return electricalApplianceUsageDao.update(newSituation,id);
    }

    @Override
    public boolean add(Integer studentId,Date date, Integer id, String newSituation) {
        ElectricalApplianceUsage electricalApplianceUsage = new ElectricalApplianceUsage();
        electricalApplianceUsage.setSituation(newSituation);
        electricalApplianceUsage.setDate(date);
        Instructor instructor = new Instructor();
        instructor.setId(id);
        Student student = studentManagementDao.searchStudentById(studentId);
        if (student==null) {
            return false; // cannot find the student.
        }
        electricalApplianceUsage.setInstructor(instructor);
        electricalApplianceUsage.setRoom(student.getRoom());
        electricalApplianceUsage.setStudent(student);

        return electricalApplianceUsageDao.add(electricalApplianceUsage);
    }

}
