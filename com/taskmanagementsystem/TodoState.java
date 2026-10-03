package com.taskmanagementsystem;

public class TodoState implements TaskState{
    @Override
    public void startProgress(Task task) {
        task.setState(new InProgressState());
        task.notifyObservers("Task moved to In Progress State");
    }

    @Override
    public void completeTask(Task task) {
        task.setState(new DoneState());
        task.notifyObservers("Task moved directly to complete state");
    }

    @Override
    public void reopenTask(Task task) {
        System.out.println("Task already in ToDo State");
    }

    @Override
    public TaskStatus getStatus() {
        return TaskStatus.TODO;
    }
}
