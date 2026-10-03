package com.taskmanagementsystem;

import java.util.List;

public class SortByPriority implements TaskSortStrategy{
    @Override
    public void sort(List<Task> tasks) {
        tasks.sort((t1,t2)->t2.getPriority().compareTo(t1.getPriority()));
    }
}
