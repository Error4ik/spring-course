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

    private String carBrand;

    private Map<String, String> departments = new HashMap<>();

    private Map<String, String> carBrands = new HashMap<>();

    public Employee() {
        this.fillMaps();
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

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public Map<String, String> getDepartments() {
        return departments;
    }

    public void setDepartments(Map<String, String> departments) {
        this.departments = departments;
    }

    public Map<String, String> getCarBrands() {
        return carBrands;
    }

    public void setCarBrands(Map<String, String> carBrands) {
        this.carBrands = carBrands;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                ", carBrand='" + carBrand + '\'' +
                '}';
    }

    private void fillMaps() {
        this.departments.put("Information Technology", "IT");
        this.departments.put("Human Resources", "HR");
        this.departments.put("Sales", "Sales");

        this.carBrands.put("BMW", "BMW");
        this.carBrands.put("AUDI", "AUDI");
        this.carBrands.put("Mercedes-Benz", "MB");
    }
}
