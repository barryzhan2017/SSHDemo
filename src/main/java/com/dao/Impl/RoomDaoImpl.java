package com.dao.Impl;

import com.dao.RoomDao;
import com.pojo.Room;
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
}
