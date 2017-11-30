package com.dao;

/**
 * Created by zhanzhicheng on 11/22/2017.
 */
public interface RoomDao {
    Integer getIdByRoomIdAndInstructorId(Integer id, String roomId);
}
