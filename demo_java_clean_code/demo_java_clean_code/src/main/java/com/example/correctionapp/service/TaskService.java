package com.example.correctionapp.service;


import com.example.correctionapp.entity.Task;
import com.example.correctionapp.entity.TaskStatus;
import com.example.correctionapp.exception.TaskNotFoundException;

import java.util.List;

public interface TaskService {
    void createTask(String name, int projectId);
    void updateTaskStatus(int taskId, TaskStatus status) throws TaskNotFoundException;
    void assignEmployeeToTask(int taskId, int employeeId);
    Task getTaskById(int id) throws TaskNotFoundException;
    List<Task> getAllTasks();
}
