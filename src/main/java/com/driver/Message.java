package com.driver;

import java.util.Date;

public class Message {
    private int id;
    private String content;
    private Date timestamp;

    public void setContent(String content) {
        this.content = content;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getContent() {
        return content;
    }

    public int getId() {
        return id;
    }

    public Date getTimestamp() {
        return timestamp;
    }


}
