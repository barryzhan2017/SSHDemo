package com.pojo;

import java.util.List;

/**
 * Created by zhanzhicheng on 11/7/2017.
 */
public class SystemAdministrator extends User {

    private List<Instructor> instructors;
    private List<DormitoryStaff> dormitoryStaffs;

    public SystemAdministrator(List<Instructor> instructors, List<DormitoryStaff> dormitoryStaffs) {
        this.instructors = instructors;
        this.dormitoryStaffs = dormitoryStaffs;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }

    public List<DormitoryStaff> getDormitoryStaffs() {
        return dormitoryStaffs;
    }

    public void setDormitoryStaffs(List<DormitoryStaff> dormitoryStaffs) {
        this.dormitoryStaffs = dormitoryStaffs;
    }
}
