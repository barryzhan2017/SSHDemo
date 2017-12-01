package com.dao.Impl;

import com.dao.RoomDao;
import com.pojo.Room;
import com.pojo.Student;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zhanzhicheng on 11/22/2017.
 */
@Transactional
public class RoomDaoImpl extends HibernateDaoSupport implements RoomDao {

    @Override
    public Integer getIdByRoomIdAndInstructorId(Integer id, String roomId) {
        String hql = "from Room room  where  room.roomName=? and room.instructor.id = ? ";
        List<Room> roomList = (List<Room>)getHibernateTemplate().find(hql,new Object[]{roomId,id});
        if (roomList.isEmpty()){
            System.out.print("no found!");
            return -1;
        }
        else {
            System.out.print(roomList.get(0).getId());
            return roomList.get(0).getId();
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Room getRoomById(int id) {
        String hql = "from Room room where room.id=?";
        return ((List<Room>) getHibernateTemplate().find(hql, new Object[] {id})).get(0);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Student getRoomLeader(int id) {
        String statement = "from Student student where student.room.id=? and student.roomLeader=?";
        List<Student> results = (List<Student>) getHibernateTemplate().find(statement, new Object[] {id, true});
        if (results.size() == 0) {
            return null;
        }
        return results.get(0);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Room> getAllRooms() {
        String statement = "from Room";
        return (List<Room>) getHibernateTemplate().find(statement);
    }
}
