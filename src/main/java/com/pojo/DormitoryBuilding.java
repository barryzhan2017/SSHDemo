package com.pojo;

import java.util.List;

/**
 * Created by zhanzhicheng on 11/7/2017.
 */
public class DormitoryBuilding {

    private Integer id;
    private Integer floor;
    private List<Room> rooms;

    public DormitoryBuilding() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
