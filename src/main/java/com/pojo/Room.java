package com.pojo;

import java.util.List;

/**
 * Created by zhanzhicheng on 11/7/2017.
 */
public class Room {
    private Integer id;
    private Integer size;
    private String gender;
    private List<Student> studentList;
    private List<SanitoryStatus> sanitoryStatusList;

    public Room(Integer id, Integer size, String gender, List<Student> studentList, List<SanitoryStatus> sanitoryStatusList) {
        this.id = id;
        this.size = size;
        this.gender = gender;
        this.studentList = studentList;
        this.sanitoryStatusList = sanitoryStatusList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<SanitoryStatus> getSanitoryStatusList() {
        return sanitoryStatusList;
    }

    public void setSanitoryStatusList(List<SanitoryStatus> sanitoryStatusList) {
        this.sanitoryStatusList = sanitoryStatusList;
    }
}
