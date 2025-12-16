package org.example;

import java.util.ArrayList;
import java.util.List;

public class TaskManager{
    private List<Task> tasks;
    private int nextId = 1;

    public TaskManager(){
        this.tasks = new ArrayList<>();
    }

    public void addTask(String description){
        Task task = new Task(nextId++, description);
        tasks.add(task);
    }

    public void removeTask(Task task){
        tasks.remove(task);
    }

    public List<Task> getTasks(){
        return tasks;
    }

    public void listTasks(){
        for(Task task : tasks){
            System.out.println(task);
        }
    }

}