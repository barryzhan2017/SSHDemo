package com.pojo;

import java.util.List;

/**
 * Created by zhanzhicheng on 11/5/2017.
 * Git
 */
public class Instructor extends User {

    private Integer chargedBuildingId;
    private List<Student> studentList;
    private List<Room> roomList;

    public Instructor(Integer chargedBuildingId, List<Student> studentList, List<Room> roomList) {
        this.chargedBuildingId = chargedBuildingId;
        this.studentList = studentList;
        this.roomList = roomList;
    }

    public Integer getChargedBuildingId() {
        return chargedBuildingId;
    }

    public void setChargedBuildingId(Integer chargedBuildingId) {
        this.chargedBuildingId = chargedBuildingId;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    @Override
    public boolean validate(String account, String password) {
        return false;
    }
}
