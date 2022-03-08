package com.example.employee.payload;

import java.util.Date;

import javax.validation.constraints.*;

public class employeeRequest {
    
    @NotBlank
    @Size(min = 3, max = 40)
    private String fullname;

    @NotBlank
    @Size(max = 10)
    private String phoneNumber;

    @NotBlank
    @Size(max = 150)
    private String address;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private Date birthDay;

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

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    
}
