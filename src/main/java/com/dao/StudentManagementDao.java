package com.dao;

import com.pojo.Student;

/**
 * Created by zhanzhicheng on 11/12/2017.
 */
public interface StudentManagementDao {
    Boolean searchStudentByRoom(Integer studentId1, Integer roomId1);
    Student searchStudentById(Integer studentId);
    void updateStudent(Student student);
}
