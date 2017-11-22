package com.service;

import com.pojo.Student;

import java.util.List;

/**
 * Created by zhanzhicheng on 11/12/2017.
 */
public interface StudentManagementService {
    Boolean changeDormitory(Integer studentId1, Integer studentId2);
    List<Student> getAllStudents();
    List<Student> getAllStudentsByInstructorId(Integer id);
    List<Student> getAllStudentsByDormitoryStaffId(Integer id);
}
