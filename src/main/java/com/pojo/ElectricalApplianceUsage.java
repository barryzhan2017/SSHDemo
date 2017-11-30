package com.pojo;

import java.util.Date;

/**
 * Created by zhanzhicheng on 11/19/2017.
 */
public class ElectricalApplianceUsage {
    private Integer id;
    private Student student;
    private Room room;
    private Date date;
    private String situation;
    private Instructor instructor;


    public ElectricalApplianceUsage() {


    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }
}
