package org.example;

public class Task{
    private int id;
    private String description;
    private boolean isDone;

    public Task(int id, String description) {
        this.id = id;
        this.description = description;
        this.isDone = false;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return isDone;
    }

    public void markDone() {
        this.isDone = true;
    }

    @Override

    public String toString() {
        String str = this.isDone ? "[X]" : "[ ]";
        str += " " + this.id + ": " + this.description;
        return str;
    }
}