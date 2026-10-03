package com.taskmanagementsystem;
import java.time.LocalDateTime;
import java.util.*;

import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class TaskManagementSystem {
    private static TaskManagementSystem taskManagementSystemInstance;

    private Map<String,User> users = new ConcurrentHashMap<>();
    private Map<String,Task> tasks = new ConcurrentHashMap<>();
    private Map<String,TaskList> taskLists = new ConcurrentHashMap<>();

    private TaskManagementSystem(){

    }

    public synchronized static TaskManagementSystem getInstance(){
        if(taskManagementSystemInstance==null){
            synchronized (TaskManagementSystem.class){
                if(taskManagementSystemInstance==null){
                    taskManagementSystemInstance=new TaskManagementSystem();
                }
            }
        }
        return taskManagementSystemInstance;
    }

    public User createUser(String name, String email){
        String id = UUID.randomUUID().toString().substring(0,8);
        User user = new User(id,name,email);
        users.put(id,user);
        return user;
    }

    public Task createTask(String creatorId, String title, String description, LocalDateTime dueDate, TaskPriority priority){
        User creator = users.get(creatorId);
        if(creator==null){
            throw new IllegalArgumentException("User with id" + creatorId + "not found");
        }
        String id = UUID.randomUUID().toString().substring(0,8);
        Task task = new Task(id,title,description,dueDate,priority,creator);
        tasks.put(id,task);
        return task;
    }

    public void deleteTask(String taskId){
        tasks.remove(taskId);
    }

    public TaskList createTaskList(String name){
        String id = UUID.randomUUID().toString().substring(0,8);
        TaskList taskList= new TaskList(id,name);
        taskLists.put(id,taskList);
        return taskList;
    }

    public List<Task> listTasksByUser(String userId){
        return tasks.values().stream()
                .filter(t->t.getAssignee()!=null && t.getAssignee().getId().equals(userId))
                .collect(Collectors.toList());
    }

    public List<Task> listTaskByStatus(TaskStatus taskStatus){
        return tasks.values().stream()
                .filter(t->t.getStatus()!=null && t.getStatus().equals(taskStatus))
                .collect(Collectors.toList());
    }

    public List<Task> searchTasks(String keyword, TaskSortStrategy sortStrategy){
        List<Task> result = tasks.values().stream()
                .filter(t->t.getTitle().toLowerCase().contains(keyword.toLowerCase())
                || t.getDescription().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());

        if(sortStrategy!=null){
            sortStrategy.sort(result);
        }
        return result;
    }

    public Task getTask(String taskId){
        return tasks.get(taskId);
    }
}
