package com.pojo;

import java.util.List;

/**
 * Created by zhanzhicheng on 11/7/2017.
 */
public class Room {
    private Integer id;
    private Integer size;
    private String gender;
    private List<Student> students;
    private List<SanitoryStatus> sanitoryStatuses;

    public Room(Integer id, Integer size, String gender, List<Student> students, List<SanitoryStatus> sanitoryStatuses) {
        this.id = id;
        this.size = size;
        this.gender = gender;
        this.students = students;
        this.sanitoryStatuses = sanitoryStatuses;
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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<SanitoryStatus> getSanitoryStatuses() {
        return sanitoryStatuses;
    }

    public void setSanitoryStatuses(List<SanitoryStatus> sanitoryStatuses) {
        this.sanitoryStatuses = sanitoryStatuses;
    }
}
