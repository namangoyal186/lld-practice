package com.taskmanagementsystem;
import java.util.*;

import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Task {
    private String id;
    private String title;
    private String description;
    private LocalDateTime dueDate;
    private TaskPriority priority;
    private User createdBy;
    private User assignee;
    private TaskState currentState;

    private List<Task> subTasks = new CopyOnWriteArrayList<>();
    private List<TaskObserver> observers = new CopyOnWriteArrayList<>();
    private List<Comment> comments = new CopyOnWriteArrayList<>();
    private List<ActivityLog> activityLogs = new CopyOnWriteArrayList<>();
    private Set<Tag> tags = ConcurrentHashMap.newKeySet();

        public Task(String id, String title, String description, LocalDateTime dueDate, TaskPriority priority, User createdBy) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.createdBy = createdBy;
        this.currentState = new TodoState();
        addObserver(new ActivityLogger());
        addLog("Task Created" + title);
    }

    public synchronized void setState(TaskState state){
        this.currentState=state;
    }

    public synchronized void startProgress(){
        currentState.startProgress(this);
    }

    public synchronized void completeTask(){
        currentState.completeTask(this);
    }

    public synchronized void reopenTask(){
        currentState.reopenTask(this);
    }

    public TaskStatus getStatus(){
        return currentState.getStatus();
    }

    public void addObserver(TaskObserver observer){
        observers.add(observer);
    }

    public void removeObserver(TaskObserver observer){
        observers.remove(observer);
    }

    public void notifyObservers(String message){
        for(TaskObserver observer:observers){
            observer.update(this,message);
        }
    }

    public synchronized void updatePriority(TaskPriority priority){
        this.priority=priority;
        notifyObservers("Priority of task updated to : " + priority);
    }

    public synchronized void setAssignee(User assignee){
        this.assignee=assignee;
        notifyObservers("Task assigned to : " + assignee);
    }

    public void addComment(Comment comment){
        comments.add(comment);
        notifyObservers("New comment added by : " + comment.getUser().getName());
    }

    public void addLog(String log){
        activityLogs.add(new ActivityLog(log));
    }

    public void addSubtask(Task subtask){
        subTasks.add(subtask);
        notifyObservers("Subtask added : "+ subtask.getTitle());
    }

    public boolean isComposite(){
        return !subTasks.isEmpty();
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

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public User getAssignee() {
        return assignee;
    }

    public List<ActivityLog> getActivityLogs() {
        return Collections.unmodifiableList(activityLogs);
    }

    public List<Comment> getComments() {
        return Collections.unmodifiableList(comments);
    }

    public void display(String indent){
        System.out.println(indent + "- [" + getStatus() + "]" + "[" + getPriority() + "]" + title + " (Due: " + dueDate + ", Assignee: " + (assignee != null ? assignee.getName() : "Unassigned") + ")");
        for (Task subtask : subTasks) {
            subtask.display(indent + "   ");
        }
    }


}
