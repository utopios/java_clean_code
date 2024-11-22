package com.example.correctionapp.service.impl;

import com.example.correctionapp.dao.GenericDAO;
import com.example.correctionapp.entity.Employee;
import com.example.correctionapp.entity.Project;
import com.example.correctionapp.exception.EmployeeNotFoundException;
import com.example.correctionapp.exception.ProjectNotFoundException;
import com.example.correctionapp.service.ProjectService;

import java.util.List;

public class ProjectServiceImpl implements ProjectService {
    private final GenericDAO<Project,Integer> projectDAO;
    private final GenericDAO<Employee,Integer> employeeDAO;

    public ProjectServiceImpl(GenericDAO<Project,Integer> projectDAO, GenericDAO<Employee,Integer> employeeDAO) {
        this.projectDAO = projectDAO;
        this.employeeDAO = employeeDAO;
    }

    @Override
    public void createProject(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Le nom du projet ne peut pas être vide.");
        }
        Project project = new Project(name);
        projectDAO.save(project);
    }

    @Override
    public void assignEmployeeToProject(int projectId, int employeeId) {
        Project project = projectDAO.findById(projectId);
        if (project == null) {
            throw new ProjectNotFoundException("Projet non trouvé avec l'ID : " + projectId);
        }
        Employee employee = employeeDAO.findById(employeeId);
        if (employee == null) {
            throw new EmployeeNotFoundException("Employé non trouvé avec l'ID : " + employeeId);
        }
        project.addEmployee(employee);
        projectDAO.update(project);
    }

    @Override
    public Project getProjectById(int id) throws ProjectNotFoundException {
        Project project = projectDAO.findById(id);
        if (project == null) {
            throw new ProjectNotFoundException("Projet non trouvé avec l'ID : " + id);
        }
        return project;
    }

    @Override
    public List<Project> getAllProjects() {
        return projectDAO.findAll();
    }
}
