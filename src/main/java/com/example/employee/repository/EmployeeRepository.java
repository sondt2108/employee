package com.example.employee.repository;

import java.util.List;

import com.example.employee.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    
    @Query(value = "select * from employee", nativeQuery = true)
        List<Employee> findAllEmpl();
}
