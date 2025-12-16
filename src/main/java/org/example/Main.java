package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Testing TaskManager...");
        TaskManager manager = new TaskManager();

        System.out.println("Adding tasks...");
        manager.addTask("Buy milk");
        manager.addTask("Walk");
        manager.addTask("Learn Java");

        System.out.println("Current Tasks:");
        manager.listTasks();
    }
}