package com.example.employee.repository;

import java.util.Optional;

import com.example.employee.model.ERole;
import com.example.employee.model.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
   
    Optional<Role>  findByName(ERole name);

}
