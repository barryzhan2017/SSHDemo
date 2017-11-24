package com.service.Impl;

import com.dao.RoomDao;
import com.dao.SanitaryStatusDao;
import com.pojo.Instructor;
import com.pojo.Room;
import com.pojo.SanitaryStatus;
import com.service.SanitaryStatusService;

import java.util.Date;
import java.util.List;

/**
 * Created by zhanzhicheng on 11/16/2017.
 */
public class SanitaryStatusServiceImpl implements SanitaryStatusService {
    SanitaryStatusDao sanitaryStatusDao;
    RoomDao roomDao;
    public SanitaryStatusDao getSanitaryStatusDao() {
        return sanitaryStatusDao;
    }

    public void setSanitaryStatusDao(SanitaryStatusDao sanitaryStatusDao) {
        this.sanitaryStatusDao = sanitaryStatusDao;
    }

    public RoomDao getRoomDao() {
        return roomDao;
    }

    public void setRoomDao(RoomDao roomDao) {
        this.roomDao = roomDao;
    }

    @Override
    public List<SanitaryStatus> getAllSanitaryStatus(Integer id) {
        return sanitaryStatusDao.getAllSanitaryStatus(id);
    }

    @Override
    public boolean addSanitaryStatus(Integer id, Integer roomId, Date date, Integer score) {
        SanitaryStatus sanitaryStatus = new SanitaryStatus();
        Room room = new Room();
        room.setId(roomId);
        Instructor instructor = new Instructor();
        instructor.setId(id);
        sanitaryStatus.setDate(date);
        sanitaryStatus.setRoom(room);
        sanitaryStatus.setScore(score);
        sanitaryStatus.setInstructor(instructor);
        return sanitaryStatusDao.addSanitaryStatus(sanitaryStatus);
    }
}
