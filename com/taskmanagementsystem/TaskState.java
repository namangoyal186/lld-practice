package com.taskmanagementsystem;

public interface TaskState {
    public void startProgress(Task task);
    public void completeTask(Task task);
    public void reopenTask(Task task);
    TaskStatus getStatus();
}

