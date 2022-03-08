package com.example.employee.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity(name ="employee")
public class Employee {
    @Id
    @GeneratedValue
    private int id;

    @NotBlank
    @Size(min = 3, max = 40)
    private String fullname;

    @NotBlank
    @Size(max=10)
    private String phoneNumber;

    @NotBlank
    @Size(min = 10, max = 150)
    private String address;

    @NotBlank
    @Email
    private String email;
    
    @NotBlank
    private Date birthDay;

    

    
}
