package com.example.correctionapp.service;

import com.example.correctionapp.entity.Project;
import com.example.correctionapp.exception.ProjectNotFoundException;

import java.util.List;

public interface ProjectService {
    void createProject(String name);
    void assignEmployeeToProject(int projectId, int employeeId);
    Project getProjectById(int id) throws ProjectNotFoundException;
    List<Project> getAllProjects();
}