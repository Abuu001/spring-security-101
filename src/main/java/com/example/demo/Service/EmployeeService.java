package com.example.demo.Service;

import com.example.demo.Entity.Employee;
import com.example.demo.Repository.DepartmentRepository;
import com.example.demo.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public Employee saveEmployee(Employee newEmployee) {
        return employeeRepository.save(newEmployee);
    }

    public List<Employee> allEmployees() {
        return employeeRepository.findAll();
    }
}
