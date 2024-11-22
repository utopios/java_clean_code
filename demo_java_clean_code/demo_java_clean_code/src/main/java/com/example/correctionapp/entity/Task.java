package com.example.correctionapp.entity;

public class Task {
    private int id;
    private String name;
    private TaskStatus status;
    private Employee assignedEmployee;

    public Task(int id, String name) {
        this.id = id;
        this.name = name;
        this.status = TaskStatus.NOT_STARTED;
    }

    // Getters et setters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStatus(TaskStatus status) {
        if (status != null) {
            this.status = status;
        }
    }

    public Employee getAssignedEmployee() {
        return assignedEmployee;
    }

    public void assignEmployee(Employee employee) {
        this.assignedEmployee = employee;
    }
}