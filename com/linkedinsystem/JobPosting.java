package com.linkedinsystem;
import java.time.LocalDateTime;
import java.util.*;

public class JobPosting {
    private String id;
    private String title;
    private String description;

    private List<String> requirements;
    private String location;

    private Member postedBy;
    private LocalDateTime postDate;

    public JobPosting(String id, String title, String description, List<String> requirements, String location, Member postedBy) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.requirements = requirements;
        this.location = location;
        this.postedBy = postedBy;
        this.postDate = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getRequirements() {
        return requirements;
    }

    public String getLocation() {
        return location;
    }

    public Member getPostedBy() {
        return postedBy;
    }

    public LocalDateTime getPostDate() {
        return postDate;
    }
}
