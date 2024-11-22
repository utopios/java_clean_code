package com.example.correctionapp.service.impl;

import com.example.correctionapp.dao.GenericDAO;
import com.example.correctionapp.entity.Employee;
import com.example.correctionapp.entity.Project;
import com.example.correctionapp.entity.Task;
import com.example.correctionapp.entity.TaskStatus;
import com.example.correctionapp.exception.EmployeeNotFoundException;
import com.example.correctionapp.exception.ProjectNotFoundException;
import com.example.correctionapp.exception.TaskNotFoundException;
import com.example.correctionapp.service.NotificationService;
import com.example.correctionapp.service.TaskService;

import java.util.List;
public class TaskServiceImpl implements TaskService {
    private final GenericDAO<Task, Integer> taskDAO;
    private final GenericDAO<Project, Integer> projectDAO;
    private final GenericDAO<Employee, Integer> employeeDAO;
    private final NotificationService notificationService;


    public TaskServiceImpl(GenericDAO<Task, Integer> taskDAO, GenericDAO<Project, Integer> projectDAO, GenericDAO<Employee, Integer> employeeDAO, NotificationService notificationService) {
        this.taskDAO = taskDAO;
        this.projectDAO = projectDAO;
        this.employeeDAO = employeeDAO;
        this.notificationService = notificationService;
    }

    @Override
    public void createTask(String name, int projectId) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Le nom de la tâche ne peut pas être vide.");
        }
        Project project = projectDAO.findById(projectId);
        if (project == null) {
            throw new ProjectNotFoundException("Projet non trouvé avec l'ID : " + projectId);
        }
        Task task = new Task(0, name); // L'ID sera attribué par le DAO
        taskDAO.save(task);
        project.addTask(task);
        projectDAO.update(project);
    }

    @Override
    public void updateTaskStatus(int taskId, TaskStatus status) {
        Task task = taskDAO.findById(taskId);
        if (task == null) {
            throw new TaskNotFoundException("Tâche non trouvée avec l'ID : " + taskId);
        }
        task.setStatus(status);
        taskDAO.update(task);
        if (task.getAssignedEmployee() != null) {
            notificationService.notifyObservers("La tâche '" + task.getName() + "' a été mise à jour.");
        }
    }

    @Override
    public void assignEmployeeToTask(int taskId, int employeeId) {
        Task task = taskDAO.findById(taskId);
        if (task == null) {
            throw new TaskNotFoundException("Tâche non trouvée avec l'ID : " + taskId);
        }
        Employee employee = employeeDAO.findById(employeeId);
        if (employee == null) {
            throw new EmployeeNotFoundException("Employé non trouvé avec l'ID : " + employeeId);
        }
        task.assignEmployee(employee);
        taskDAO.update(task);
    }

    @Override
    public Task getTaskById(int id) throws TaskNotFoundException {
        Task task = taskDAO.findById(id);
        if (task == null) {
            throw new TaskNotFoundException("Tâche non trouvée avec l'ID : " + id);
        }
        return task;
    }

    @Override
    public List<Task> getAllTasks() {
        return taskDAO.findAll();
    }
}
