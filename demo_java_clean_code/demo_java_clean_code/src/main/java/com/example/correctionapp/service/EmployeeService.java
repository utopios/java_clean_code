package com.example.correctionapp.service;

import com.example.correctionapp.entity.Employee;
import com.example.correctionapp.exception.EmployeeNotFoundException;

import java.util.List;


public interface EmployeeService {
    void addEmployee(String name, String role);
    Employee getEmployeeById(int id) throws EmployeeNotFoundException;
    List<Employee> getAllEmployees();
}