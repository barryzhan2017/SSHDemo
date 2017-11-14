package com.pojo;

import java.util.Date;

/**
 * Created by zhanzhicheng on 11/7/2017.
 */
public class RepairingEquipment {
    private Integer id;
    private Room room;
    private String  description;
    private Date date;
    private boolean repaired;
    private DormitoryStaff dormitoryStaff;

    public RepairingEquipment() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isRepaired() {
        return repaired;
    }

    public void setRepaired(boolean repaired) {
        this.repaired = repaired;
    }

    public DormitoryStaff getDormitoryStaff() {
        return dormitoryStaff;
    }

    public void setDormitoryStaff(DormitoryStaff dormitoryStaff) {
        this.dormitoryStaff = dormitoryStaff;
    }
}
