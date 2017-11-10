package com.pojo;

import java.util.List;

/**
 * Created by zhanzhicheng on 11/5/2017.
 * Git
 */
public class Instructor extends User{


    private Integer chargedBuildingId;
    private List<Student> students;
    private List<Room> rooms;
    private Integer systemAdministratorId;

    public Instructor() {

    }

    public Integer getSystemAdministratorId() {
        return systemAdministratorId;
    }

    public void setSystemAdministratorId(Integer systemAdministratorId) {
        this.systemAdministratorId = systemAdministratorId;
    }

    public Integer getChargedBuildingId() {
        return chargedBuildingId;
    }

    public void setChargedBuildingId(Integer chargedBuildingId) {
        this.chargedBuildingId = chargedBuildingId;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
