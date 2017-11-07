package com.pojo;

import java.util.Date;

/**
 * Created by zhanzhicheng on 11/7/2017.
 */
public class SanitoryStatus {
    private Integer roomId;
    private Date date;
    private Integer score;

    //test
    public SanitoryStatus(Integer roomId, Date date, Integer score) {
        this.roomId = roomId;
        this.date = date;
        this.score = score;
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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
