package com.pojo;

import java.util.Date;

/**
 * Created by zhanzhicheng on 11/7/2017.
 */
public class BorrowingKey {
    private Integer id;
    private Student student;
    private Room room;
    private Date date;
    private DormitoryStaff dormitoryStaff;
    private Boolean returned;

    public BorrowingKey() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public DormitoryStaff getDormitoryStaff() {
        return dormitoryStaff;
    }

    public void setDormitoryStaff(DormitoryStaff dormitoryStaff) {
        this.dormitoryStaff = dormitoryStaff;
    }

    public Boolean getReturned() {
        return returned;
    }

    public void setReturned(Boolean returned) {
        this.returned = returned;
    }
}
