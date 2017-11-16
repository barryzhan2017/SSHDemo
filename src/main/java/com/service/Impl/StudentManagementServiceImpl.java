package com.service.Impl;

import com.dao.StudentManagementDao;
import com.pojo.DormitoryBuilding;
import com.pojo.Room;
import com.pojo.Student;
import com.service.StudentManagementService;

import java.util.List;

/**
 * Created by zhanzhicheng on 11/12/2017.
 */
public class StudentManagementServiceImpl implements StudentManagementService {

    StudentManagementDao studentManagementDao;

    public StudentManagementDao getStudentManagementDao() {
        return studentManagementDao;
    }

    public void setStudentManagementDao(StudentManagementDao studentManagementDao) {
        this.studentManagementDao = studentManagementDao;
    }

    //change two students to the other's dormitory.
    @Override
    public Boolean changeDormitory(Integer studentId1, Integer studentId2) {
        Student student1 = studentManagementDao.searchStudentById(studentId1);
        Student student2 = studentManagementDao.searchStudentById(studentId2);
        //go on changing when students exist, they live in dormitory,their genders are same.
        if (student1!=null&&student2!=null&&student1.getRoom()!=null&&student2.getRoom()!=null&&!student1.getGender().equals(student2.getGender())) {
            Room room = student1.getRoom();
            Integer bedId = student1.getBedId();
            student1.setRoom(student2.getRoom());
            student1.setBedId(student2.getBedId());
            student2.setRoom(room);
            student2.setBedId(bedId);
            studentManagementDao.updateStudent(student1);
            studentManagementDao.updateStudent(student2);
            return true;
        }
        return false;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentManagementDao.getAllStudents();
    }

    @Override
    public List<Student> getAllStudentsByInstructorId(Integer id) {
        return studentManagementDao.getAllStudentsByInstructorId(id);
    }

    @Override
    public List<Student> getAllStudentsByDormitoryStaffId(Integer id) {
        return studentManagementDao.getAllStudentsByDormitoryStaffId(id);
    }
}
