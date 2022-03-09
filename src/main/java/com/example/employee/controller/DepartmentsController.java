package com.example.employee.controller;

import java.util.List;

import javax.validation.Valid;

import com.example.employee.model.Departments;
import com.example.employee.payload.request.DepartmentsRequest;
import com.example.employee.payload.response.MessageResponse;
import com.example.employee.repository.DepartmentsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentsController {
    
    @Autowired
    DepartmentsRepository departmentsRepository;

    @GetMapping(value = "/getAllDept")
    public List<Departments> getAllDept(){

        return departmentsRepository.findAll();
    }

    @PostMapping(value = "/insertDept")
    public ResponseEntity<?> insertDept(@RequestBody @Valid DepartmentsRequest departmentsRequest) {
        Departments dept = new Departments();
        dept.setDeptName(departmentsRequest.getDeptName());

        departmentsRepository.save(dept);
        return ResponseEntity.ok(new MessageResponse("add dept success"));
    }

    @PutMapping(value = "/updateDept")
    public ResponseEntity<?> updateDept(@RequestBody @Valid Departments departments) {

            departmentsRepository.save(departments);

        return ResponseEntity.ok(new MessageResponse("update dept success"));
    }

    @GetMapping(value = "/getDeptById/{id}")
    public Departments getDeptById(@PathVariable("id") int id){

        return departmentsRepository.findById(id).orElse(null);
    }

    @DeleteMapping(value = "deleteDeptById/{id}")
    public ResponseEntity<?> deleteDeptById(@PathVariable("id") int id){
            departmentsRepository.deleteById(id);
        return ResponseEntity.ok(new MessageResponse("remove detp success"));
    }


}
