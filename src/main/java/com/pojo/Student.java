package com.pojo;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by zhanzhicheng on 11/6/2017.
 */
public class Student {
    private Integer id;
    private String name;
    private String major;
    private String photoURL;
    private Integer grade;
    private Integer phoneNumber;
    private String college;
    private String gender;
    private Room room;//不能写成Integer roomID
    private Integer bedId;
    private Integer classNum;
    private Boolean RoomLeader;
    private Boolean legalElectricalAppliance;
    private Boolean onCampus;
    private DormitoryStaff dormitoryStaff;
    private Instructor instructor;

    public Student() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Integer getBedId() {
        return bedId;
    }

    public void setBedId(Integer bedId) {
        this.bedId = bedId;
    }

    public Integer getClassNum() {
        return classNum;
    }

    public void setClassNum(Integer classNum) {
        this.classNum = classNum;
    }

    public Boolean getRoomLeader() {
        return RoomLeader;
    }

    public void setRoomLeader(Boolean roomLeader) {
        RoomLeader = roomLeader;
    }

    public Boolean getLegalElectricalAppliance() {
        return legalElectricalAppliance;
    }

    public void setLegalElectricalAppliance(Boolean legalElectricalAppliance) {
        this.legalElectricalAppliance = legalElectricalAppliance;
    }

    public Boolean getOnCampus() {
        return onCampus;
    }

    public void setOnCampus(Boolean onCampus) {
        this.onCampus = onCampus;
    }

    public DormitoryStaff getDormitoryStaff() {
        return dormitoryStaff;
    }

    public void setDormitoryStaff(DormitoryStaff dormitoryStaff) {
        this.dormitoryStaff = dormitoryStaff;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}
