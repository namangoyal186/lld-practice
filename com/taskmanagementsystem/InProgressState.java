package com.taskmanagementsystem;

public class InProgressState implements TaskState{
    @Override
    public void startProgress(Task task) {
        System.out.println("Task is already in progress state");
    }

    @Override
    public void completeTask(Task task) {
        task.setState(new DoneState());
        task.notifyObservers("Task marked in Done State from In progress State");
    }

    @Override
    public void reopenTask(Task task) {
        task.setState(new TodoState());
        System.out.println("Task reverted to TODO");
    }

    @Override
    public TaskStatus getStatus() {
        return TaskStatus.IN_PROGRESS;
    }
}
