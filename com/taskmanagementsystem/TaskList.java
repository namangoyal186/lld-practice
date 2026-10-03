package com.taskmanagementsystem;
import java.util.*;

import java.util.concurrent.CopyOnWriteArrayList;

public class TaskList {
    private String id;
    private String name;
    private List<Task> tasks = new CopyOnWriteArrayList<>();

    public TaskList(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addTask(Task task){
        tasks.add(task);
    }

    public void display(){
        System.out.println("Tasklist: " + name);
        for(Task task:tasks){
            task.display(" ");
        }
    }

}
