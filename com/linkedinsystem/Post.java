package com.linkedinsystem;
import java.util.*;

import java.time.LocalDateTime;
import java.util.concurrent.CopyOnWriteArrayList;

public class Post {
    private String postId;
    private Member author;

    private LocalDateTime createdAt;
    private String content;

    private List<Member> likes;
    private List<Comment> comments;

    public Post(String postId, Member author, String content) {
        this.postId = postId;
        this.author = author;
        this.createdAt = LocalDateTime.now();
        this.content = content;
        this.likes = new CopyOnWriteArrayList<>();
        this.comments = new CopyOnWriteArrayList<>();
    }

    public void addLike(Member member){
        likes.add(member);
    }

    public void addComment(Comment comment){
        comments.add(comment);
    }

    public Member getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
