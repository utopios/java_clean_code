package com.example.correctionapp.entity;

import java.util.ArrayList;
import java.util.List;


public class Project {
    private int id;
    private String name;
    private final List<Employee> employees = new ArrayList<>();
    private final List<Task> tasks = new ArrayList<>();

    public Project(String name) {
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void addEmployee(Employee employee) {
        if (employee != null && !employees.contains(employee)) {
            employees.add(employee);
        }
    }

    public List<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }

    public void addTask(Task task) {
        if (task != null && !tasks.contains(task)) {
            tasks.add(task);
        }
    }

    public List<Task> getTasks() {
        return new ArrayList<>(tasks);
    }
}
