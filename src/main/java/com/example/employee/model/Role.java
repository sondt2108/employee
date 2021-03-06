package com.example.employee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="roles")
public class Role {
    @Id
    @GeneratedValue
    private int id;


    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;


    public Role() {
    }


    public Role(ERole name) {
        this.name = name;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public ERole getName() {
        return name;
    }


    public void setName(ERole name) {
        this.name = name;
    }

    

}
