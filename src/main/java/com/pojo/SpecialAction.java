package com.pojo;

import java.util.Date;

/**
 * Created by zhanzhicheng on 11/7/2017.
 */
public class SpecialAction {
    private Integer roomId;
    private Integer studentId;
    private String studentName;
    private String  actionType;
    private Date date;

    public SpecialAction(Integer roomId, Integer studentId, String studentName, String actionType, Date date) {
        this.roomId = roomId;
        this.studentId = studentId;
        this.studentName = studentName;
        this.actionType = actionType;
        this.date = date;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
