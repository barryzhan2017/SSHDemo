package com.pojo;

import java.util.Date;

/**
 * Created by zhanzhicheng on 11/7/2017.
 */
public class VisitorRecord {
    private String name;
    private Integer id;
    private String reason;
    private Date date;
    private boolean leaveStatus;

    public VisitorRecord(String name, Integer id, String reason, Date date, boolean leaveStatus) {
        this.name = name;
        this.id = id;
        this.reason = reason;
        this.date = date;
        this.leaveStatus = leaveStatus;
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
