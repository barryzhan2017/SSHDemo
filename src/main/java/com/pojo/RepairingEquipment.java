package com.pojo;

import java.util.Date;

/**
 * Created by zhanzhicheng on 11/7/2017.
 */
public class RepairingEquipment {
    private Integer id;
    private Integer roomId;
    private String  description;
    private Date date;
    private boolean repaired;
    private Integer dormitoryStaffId;

    public RepairingEquipment() {

    }


    public Integer getId() {
        return id;
    }

    public Integer getDormitoryStaffId() {
        return dormitoryStaffId;
    }

    public void setDormitoryStaffId(Integer dormitoryStaffId) {
        this.dormitoryStaffId = dormitoryStaffId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
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
}
