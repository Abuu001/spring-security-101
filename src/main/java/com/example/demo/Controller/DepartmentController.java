package com.example.demo.Controller;

import com.example.demo.Entity.Department;
import com.example.demo.Service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/newdepartment")
    public Department saveDepartment(@RequestBody Department newDepartment){
        log.info("Inside saveDepartment controller");
        return  departmentService.saveDepartment(newDepartment);
    }

    @GetMapping("/find/{departmentId}")
    public Department findDepartment(@PathVariable("departmentId") Long departmentId){
        log.info("Inside find department by id -- service");
        return departmentService.findDepartment(departmentId);
    }
}


