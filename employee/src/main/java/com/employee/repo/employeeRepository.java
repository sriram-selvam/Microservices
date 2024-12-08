package com.employee.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.entity.employeeEntity;

public interface employeeRepository extends JpaRepository<employeeEntity, Integer>{

}
