package com.example.employee.controller;

import java.util.List;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/getAll")
    public List<Employee> getAll() {

        return employeeRepository.findAllEmpl();
    }

    
}
