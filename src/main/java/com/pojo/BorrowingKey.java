package com.pojo;

import java.util.Date;

/**
 * Created by zhanzhicheng on 11/7/2017.
 */
public class BorrowingKey {
    private Integer studentId;
    private String  studentName;
    private Integer roomId;
    private Date date;

    public BorrowingKey(Integer studentId, String studentName, Integer roomId, Date date) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.roomId = roomId;
        this.date = date;
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

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
