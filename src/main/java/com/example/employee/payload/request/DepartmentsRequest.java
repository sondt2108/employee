package com.example.employee.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class DepartmentsRequest {
    
    @NotBlank
    @Size(min =2, max = 45)
    private String deptName;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }


    
}
