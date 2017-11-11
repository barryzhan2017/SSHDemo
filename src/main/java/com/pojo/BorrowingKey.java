package com.pojo;

import java.util.Date;

/**
 * Created by zhanzhicheng on 11/7/2017.
 */
public class BorrowingKey {
    private Integer id;
    private Integer studentId;
    private String  studentName;
    private Integer roomId;
    private Date date;
    private Integer dormitoryStaffId;
    private Boolean returned;

    public BorrowingKey() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getDormitoryStaffId() {
        return dormitoryStaffId;
    }

    public void setDormitoryStaffId(Integer dormitoryStaffId) {
        this.dormitoryStaffId = dormitoryStaffId;
    }

    public Boolean getReturned() {
        return returned;
    }

    public void setReturned(Boolean returned) {
        this.returned = returned;
    }
}
