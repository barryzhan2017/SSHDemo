package com.pojo;

import java.util.List;

/**
 * Created by zhanzhicheng on 11/7/2017.
 */
public class Room {
    private Integer id;
    private String roomId;
    private Integer size;
    private String gender;
    private List<Student> students;
    private List<SanitaryStatus> sanitaryStatuses;
    private List<RepairingEquipment> repairingEquipments;
    private Instructor instructor;
    private DormitoryBuilding dormitoryBuilding;

    public Room() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<SanitaryStatus> getSanitaryStatuses() {
        return sanitaryStatuses;
    }

    public void setSanitaryStatuses(List<SanitaryStatus> sanitaryStatuses) {
        this.sanitaryStatuses = sanitaryStatuses;
    }

    public List<RepairingEquipment> getRepairingEquipments() {
        return repairingEquipments;
    }

    public void setRepairingEquipments(List<RepairingEquipment> repairingEquipments) {
        this.repairingEquipments = repairingEquipments;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public DormitoryBuilding getDormitoryBuilding() {
        return dormitoryBuilding;
    }

    public void setDormitoryBuilding(DormitoryBuilding dormitoryBuilding) {
        this.dormitoryBuilding = dormitoryBuilding;
    }
}
