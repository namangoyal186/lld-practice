package com.taskmanagementsystem;

public class DoneState implements TaskState{
    @Override
    public void startProgress(Task task) {
        System.out.println("Task is already in done state.Reopen it first.");
    }

    @Override
    public void completeTask(Task task) {
        System.out.println("Task is already done");
    }

    @Override
    public void reopenTask(Task task) {
        task.setState(new TodoState());
        task.notifyObservers("Task reopened in ToDo state from Done state");
    }

    @Override
    public TaskStatus getStatus() {
        return TaskStatus.DONE;
    }
}
