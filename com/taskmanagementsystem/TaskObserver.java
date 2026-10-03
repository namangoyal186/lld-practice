package com.taskmanagementsystem;

public interface TaskObserver {
    void update(Task task, String message);
}
