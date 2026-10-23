package com.linkedinsystem;

import java.time.LocalDateTime;

public class Notification {
    private String id;
    private LocalDateTime createdAt;
    private NotificationType type;
    private Member member;
    private String content;
    private boolean read;

    public Notification(String id, NotificationType type, Member member, String content) {
        this.id = id;
        this.createdAt = LocalDateTime.now();
        this.type = type;
        this.member = member;
        this.content = content;
        this.read = false;
    }

    public void markAsRead(){
        read=true;
    }

    public String getContent(){
        return content;
    }

    @Override
    public String toString() {
        return type + ": " + content;
    }
}
