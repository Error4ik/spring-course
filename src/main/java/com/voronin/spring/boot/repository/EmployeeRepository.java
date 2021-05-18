package com.voronin.spring.boot.repository;

import com.voronin.spring.boot.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findAllByName(String name);
}
