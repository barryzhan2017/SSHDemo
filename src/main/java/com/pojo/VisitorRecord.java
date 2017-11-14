package com.pojo;

import java.util.Date;

/**
 * Created by zhanzhicheng on 11/7/2017.
 */
public class VisitorRecord {
    private Integer id;
    private String name;
    private Integer visitorId;
    private String reason;
    private Date date;
    private boolean leaveStatus;
    private DormitoryStaff dormitoryStaff;

    public VisitorRecord() {

    }

    public DormitoryStaff getDormitoryStaff() {
        return dormitoryStaff;
    }

    public void setDormitoryStaff(DormitoryStaff dormitoryStaff) {
        this.dormitoryStaff = dormitoryStaff;
    }

    public Integer getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Integer visitorId) {
        this.visitorId = visitorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isLeaveStatus() {
        return leaveStatus;
    }

    public void setLeaveStatus(boolean leaveStatus) {
        this.leaveStatus = leaveStatus;
    }
}
