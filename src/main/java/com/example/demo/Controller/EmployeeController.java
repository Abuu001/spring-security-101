package com.example.demo.Controller;

import com.example.demo.Entity.Employee;
import com.example.demo.Service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employee")
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/newemployee")
    public Employee saveEmployee(@RequestBody Employee newEmployee){
        return employeeService.saveEmployee(newEmployee);
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployees(){
        return employeeService.allEmployees();
    }

}
