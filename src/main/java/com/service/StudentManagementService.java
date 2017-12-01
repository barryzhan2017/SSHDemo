package com.service;

import com.pojo.Room;
import com.pojo.Student;
import com.pojo.User;

import java.util.List;

/**
 * Created by zhanzhicheng on 11/12/2017.
 */
public interface StudentManagementService {
    Boolean changeDormitory(Integer studentId1, Integer studentId2);
    List<Student> getAllStudentsByInstructorId(Integer id);
    List<Student> getAllStudentsByDormitoryStaffId(Integer id);
    boolean addStudentToDormitory(Integer studentId, Integer roomId, Integer bedId, Integer instructorId);
    boolean removeStudentFromDormitory(Integer studentId, Integer roomId, Integer id);
    boolean appointRoomLeader(Integer studentId, Integer roomId, Integer id);
    Student getRoomLeader(int roomId);

    Room getRoomById(int id);
    List<Room> getAllRooms();
}
