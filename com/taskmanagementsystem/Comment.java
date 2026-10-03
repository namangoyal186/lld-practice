package com.taskmanagementsystem;

import java.util.Date;

public class Comment {
    private String id;
    private String content;
    private User user;
    private Date timestamp;

    public Comment(String id, String content, User user) {
        this.id = id;
        this.content = content;
        this.user = user;
        this.timestamp = new Date();
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", user=" + user +
                ", timestamp=" + timestamp +
                '}';
    }
}
