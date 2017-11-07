package com.pojo;

import java.util.Date;

/**
 * Created by zhanzhicheng on 11/7/2017.
 */
public class RepairingEquipment {
    private Integer roomId;
    private String  description;
    private Date date;
    private boolean isRepaired;

    public RepairingEquipment(Integer roomId, String description, Date date, boolean isRepaired) {
        this.roomId = roomId;
        this.description = description;
        this.date = date;
        this.isRepaired = isRepaired;
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
        return isRepaired;
    }

    public void setRepaired(boolean repaired) {
        isRepaired = repaired;
    }
}
