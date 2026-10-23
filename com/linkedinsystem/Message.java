package com.linkedinsystem;

import java.time.LocalDateTime;

public class Message {
    private String id;
    private Member sender;
    private Member receiver;

    private String content;
    private LocalDateTime timestamp;

    public Message(String id, Member sender, Member receiver, String content) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public Member getSender() {
        return sender;
    }

    public Member getReceiver() {
        return receiver;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
