package com.example.employee.model;


import javax.persistence.*;
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
    
    

    @ManyToOne
    @JoinColumn(
			name = "dept_id",
			nullable = true,
			foreignKey = @ForeignKey(name = "departmants_employee"))
	private Departments departments;

    public Employee() {
    }

    public Employee(int id, @NotBlank @Size(min = 3, max = 40) String fullname,
            @NotBlank @Size(max = 10) String phoneNumber, @NotBlank @Size(min = 10, max = 150) String address,
            @NotBlank @Email String email) {
        this.id = id;
        this.fullname = fullname;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        
    }

    public Departments getDepartments() {
        return departments;
    }

    public void setDepartments(Departments departments) {
        this.departments = departments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   

    

    
}
