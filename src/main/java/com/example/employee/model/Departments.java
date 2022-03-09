package com.example.employee.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity(name ="departments")
public class Departments {
    
    @Id
    @GeneratedValue
    private int id;


    @NotBlank
    @Size(min = 2, max = 45)
    private String deptName;

    @JsonIgnore
	@OneToMany(fetch = FetchType.LAZY
			, mappedBy = "departments")
	private List<Departments> departments;

    public Departments() {
    }

    public Departments(int id, @NotBlank @Size(min = 2, max = 45) String deptName, List<Departments> departments) {
        this.id = id;
        this.deptName = deptName;
        this.departments = departments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<Departments> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Departments> departments) {
        this.departments = departments;
    }

    
}
