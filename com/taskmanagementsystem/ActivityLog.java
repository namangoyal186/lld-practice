package com.taskmanagementsystem;

import java.time.LocalDateTime;

public class ActivityLog {
    private LocalDateTime timestamp;
    private String description;

    public ActivityLog(String description) {
        this.timestamp = LocalDateTime.now();
        this.description = description;
    }

    @Override
    public String toString() {
        return "ActivityLog{" +
                "timestamp=" + timestamp +
                ", description='" + description + '\'' +
                '}';
    }
}
