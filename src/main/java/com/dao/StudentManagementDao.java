package com.dao;

import com.pojo.Student;

import java.util.List;

/**
 * Created by zhanzhicheng on 11/12/2017.
 */
public interface StudentManagementDao {
//    Boolean searchStudentByRoom(Integer studentId1, String roomId1);
    Student searchStudentById(Integer studentId);
    void updateStudent(Student student);
    List<Student> getAllStudents();
    List<Student> getAllStudentsByInstructorId(Integer id);
    List<Student> getAllStudentsByDormitoryStaffId(Integer id);
    boolean isStudentOccupied(Integer roomId, Integer bedId);
}
