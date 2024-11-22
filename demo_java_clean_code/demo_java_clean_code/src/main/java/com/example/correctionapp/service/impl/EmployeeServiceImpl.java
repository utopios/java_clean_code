package com.example.correctionapp.service.impl;

import com.example.correctionapp.dao.GenericDAO;
import com.example.correctionapp.entity.Employee;
import com.example.correctionapp.exception.EmployeeNotFoundException;
import com.example.correctionapp.service.EmployeeService;

import java.util.List;
public class EmployeeServiceImpl implements EmployeeService {
    private final GenericDAO<Employee, Integer> employeeDAO;

    public EmployeeServiceImpl(GenericDAO<Employee, Integer> employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public void addEmployee(String name, String role) {
        if (name == null || name.isEmpty() || role == null || role.isEmpty()) {
            throw new IllegalArgumentException("Le nom et le rôle de l'employé sont obligatoires.");
        }
        Employee employee = new Employee(0, name, role); // L'ID sera attribué par le DAO
        employeeDAO.save(employee);
    }

    @Override
    public Employee getEmployeeById(int id) throws EmployeeNotFoundException {
        Employee employee = employeeDAO.findById(id);
        if (employee == null) {
            throw new EmployeeNotFoundException("Employé non trouvé avec l'ID : " + id);
        }
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.findAll();
    }
}
