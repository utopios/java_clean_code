package com.example.correctionapp;


import com.example.correctionapp.dao.EmployeeDAO;
import com.example.correctionapp.dao.GenericDAO;
import com.example.correctionapp.dao.ProjectDAO;
import com.example.correctionapp.dao.TaskDAO;
import com.example.correctionapp.entity.Employee;
import com.example.correctionapp.entity.Project;
import com.example.correctionapp.entity.Task;
import com.example.correctionapp.entity.TaskStatus;
import com.example.correctionapp.exception.EmployeeNotFoundException;
import com.example.correctionapp.exception.ProjectNotFoundException;
import com.example.correctionapp.exception.TaskNotFoundException;
import com.example.correctionapp.notifier.EmployeeNotifier;
import com.example.correctionapp.service.EmployeeService;
import com.example.correctionapp.service.NotificationService;
import com.example.correctionapp.service.ProjectService;
import com.example.correctionapp.service.TaskService;
import com.example.correctionapp.service.impl.EmployeeServiceImpl;
import com.example.correctionapp.service.impl.ProjectServiceImpl;
import com.example.correctionapp.service.impl.TaskServiceImpl;

public class Main {
    public static void main(String[] args) {
        // Initialisation des DAO
        GenericDAO<Project,Integer> projectDAO = new ProjectDAO();
        GenericDAO<Employee,Integer> employeeDAO = new EmployeeDAO();
        GenericDAO<Task,Integer> taskDAO = new TaskDAO();

        // Initialisation des services
        ProjectService projectService = new ProjectServiceImpl(projectDAO, employeeDAO);
        EmployeeService employeeService = new EmployeeServiceImpl(employeeDAO);
        NotificationService notificationService = new NotificationService();
        notificationService.addObserver(new EmployeeNotifier());
        TaskService taskService = new TaskServiceImpl(taskDAO, projectDAO, employeeDAO, notificationService);

        try {
            // Création d'un projet
            projectService.createProject("Migration Système");

            // Ajout d'employés
            employeeService.addEmployee("John Doe", "Développeur");
            employeeService.addEmployee("Jane Smith", "Analyste");

            // Assignation des employés au projet
            projectService.assignEmployeeToProject(1, 1);
            projectService.assignEmployeeToProject(1, 2);

            // Création de tâches
            taskService.createTask("Mettre à jour la base de données", 1);
            taskService.createTask("Analyser les besoins", 1);

            // Assignation d'employés aux tâches
            taskService.assignEmployeeToTask(1, 1);
            taskService.assignEmployeeToTask(2, 2);

            // Mise à jour du statut des tâches
            taskService.updateTaskStatus(1, TaskStatus.IN_PROGRESS);

            // Affichage des projets
            Project project = projectService.getProjectById(1);
            System.out.println("Projet : " + project.getName());

            // Affichage des employés
            for (var employee : employeeService.getAllEmployees()) {
                System.out.println("Employé : " + employee.getName());
            }

        } catch (ProjectNotFoundException | EmployeeNotFoundException | TaskNotFoundException e) {
            System.err.println("Erreur : " + e.getMessage());
        }
    }
}
