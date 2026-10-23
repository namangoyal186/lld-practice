package com.linkedinsystem;

import java.time.LocalDateTime;

public class Comment {
    private String text;
    private Member author;
    private LocalDateTime createdAt;

    public Comment(String text, Member author) {
        this.text = text;
        this.author = author;
        this.createdAt = LocalDateTime.now();
    }

    public String getText() {
        return text;
    }

    public Member getAuthor() {
        return author;
    }
}
