package com.example.employee.demoaop;

public class EmployeeTest {
    private String name;
    private String email;

    public String getName() {
        System.out.println("do getName()");
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        System.out.println("do getEmail()");
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void printThrowException() {
        throw new IllegalArgumentException();
    }


}
