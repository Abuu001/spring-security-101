package com.example.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeId;

    @Column(name = "employee_name",nullable = false)
    private String empName;
    @Column(unique = true)
    private String email;

    @Autowired
    @OneToMany(cascade = CascadeType.ALL)
    private List<Department> department;

    @Column(name ="dob")
    private LocalDate dateOfBirth;

    @Transient
    private Integer age;

    public Integer getAge() {

        //current date
        LocalDate now = LocalDate.now();

        Period period = Period.between(dateOfBirth,now);

        return period.getYears();
    }
}
