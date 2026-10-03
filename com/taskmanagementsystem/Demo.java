package com.taskmanagementsystem;
import java.util.*;
import java.time.LocalDateTime;

public class Demo {
    public static void main(String[] args){
        TaskManagementSystem taskManagementSystem = TaskManagementSystem.getInstance();

        User alice = taskManagementSystem.createUser("Alice","alice@gmail.com");
        User bob = taskManagementSystem.createUser("Bob","bob@gmail.com");

        Task task1 = taskManagementSystem.createTask(alice.getId(),"API Redesign","Java 21 Compatible API Designing", LocalDateTime.now().plusDays(5),TaskPriority.HIGH);
        Task task2 = taskManagementSystem.createTask(alice.getId(),"Database Revamp","Database query Optimization", LocalDateTime.now().plusDays(2),TaskPriority.CRITICAL);

        task1.setAssignee(bob);
        task2.setAssignee(bob);

        Task subtask= new Task("ST-1","Define Schema", "Schema draft",LocalDateTime.now().plusDays(3),TaskPriority.HIGH,bob);
        task1.addSubtask(subtask);

        task1.startProgress();
        task2.startProgress();
        task2.completeTask();

        task1.addComment(new Comment("C1","Initial Draft Ready",bob));

        TaskList sprintList = taskManagementSystem.createTaskList("Sprint 42");
        sprintList.addTask(task1);
        sprintList.addTask(task2);

        System.out.println("=== Task List Hierarchy ===");
        sprintList.display();

        System.out.println("\n=== Search Tasks Sorted by Due Date ===");
        List<Task> sortedBydue = taskManagementSystem.searchTasks("e",new SortByDueDate());
        for(Task t:sortedBydue){
            System.out.println(t.getAssignee() + " Title- " + t.getTitle() + " Desc- " + t.getDescription() + " Due Date- " + t.getDueDate());
        }

        System.out.println("\n=== Activity Log for Task 1 ===");
        for(ActivityLog activityLog:task1.getActivityLogs()){
            System.out.println(activityLog);
        }


    }
}
