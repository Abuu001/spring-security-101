package com.example.demo.Service;

import com.example.demo.Entity.Department;
import com.example.demo.Repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department newDepartment) {
        log.info("Inside save department --service");
        return departmentRepository.save(newDepartment);
    }

    public Department findDepartment(Long departmentId){
        log.info("Inside find department by id -- service");
        return departmentRepository.findByDepartmentId(departmentId);
    }
}
