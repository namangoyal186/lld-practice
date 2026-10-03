package com.taskmanagementsystem;

public class ActivityLogger implements TaskObserver{
    @Override
    public void update(Task task, String message) {
        task.addLog(message);
    }
}
