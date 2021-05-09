package com.voronin.spring.mvc.model;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Employee {

    private String name;

    private String surname;

    private int salary;

    private String department;

    private Map<String, String> departments = new HashMap<>();

    public Employee() {
        this.fillDepartments();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Map<String, String> getDepartments() {
        return departments;
    }

    public void setDepartments(Map<String, String> departments) {
        this.departments = departments;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }

    private void fillDepartments() {
        this.departments.put("Information Technology", "IT");
        this.departments.put("Human Resources", "HR");
        this.departments.put("Sales", "Sales");
    }
}
