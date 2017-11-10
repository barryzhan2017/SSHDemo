package com.pojo;

import java.util.Date;

/**
 * Created by zhanzhicheng on 11/7/2017.
 */
public class SanitaryStatus {
    private Integer id;
    private Integer roomId;
    private Date date;
    private Integer score;

    public SanitaryStatus() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoomId() { return roomId;}

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) { this.date = date;}

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
