package com.pojo;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by zhanzhicheng on 11/6/2017.
 */
public class Student {
    private Integer id;
    private  String name;
    private String major;
    private  Byte[] photo;
    private Integer grade;
    private Integer phoneNumber;
    private String college;
    private String gender;
    private Integer buildingId;
    private Integer roomId;
    private Integer bedId;
    private Integer classNum;
    private Boolean isRoomLeader;
    private Boolean legalElectricalAppliance;
    private Boolean onCampus;

    public Student(Integer id, String name, String major, Byte[] photo, Integer grade, Integer phoneNumber,
                   String college, String gender, Integer buildingId, Integer roomId, Integer bedId, Integer classNum) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.photo = photo;
        this.grade = grade;
        this.phoneNumber = phoneNumber;
        this.college = college;
        this.gender = gender;
        this.buildingId = buildingId;
        this.roomId = roomId;
        this.bedId = bedId;
        this.classNum = classNum;
        this.isRoomLeader = false;
        this.legalElectricalAppliance = true;
        this.onCampus = true;
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

    public Byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(Byte[] photo) {
        this.photo = photo;
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

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
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
        return isRoomLeader;
    }

    public void setRoomLeader(Boolean roomLeader) {
        isRoomLeader = roomLeader;
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
}
