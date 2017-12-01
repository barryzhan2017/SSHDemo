package com.dao;

import com.pojo.Room;
import com.pojo.Student;

import java.util.List;

/**
 * Created by zhanzhicheng on 11/22/2017.
 */
public interface RoomDao {
    Integer getIdByRoomIdAndInstructorId(Integer id, String roomId);
    Room getRoomById(int id);
    Student getRoomLeader(int id);
    List<Room> getAllRooms();
}
