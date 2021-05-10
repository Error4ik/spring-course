package com.voronin.spring.mvc.model;

import com.voronin.spring.mvc.validation.CheckEmail;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Employee {

    @Size(min = 2, max = 15, message = "The name must contain at least 2 and no more than 15 characters")
    private String name;

    @Size(min = 2, max = 15, message = "The surname must contain at least 2 and no more than 15 characters")
    private String surname;

    @Min(value = 500, message = "Salary must be greater than 499")
    @Max(value = 1000, message = "Salary must be less than 1001")
    private int salary;

    private String department;

    private String carBrand;

    private List<String> languages;

    @Pattern(regexp = "\\d{3}-\\d{2}-\\d{2}", message = "please use pattern xxx-xx-xx")
    private String phoneNumber;

    @CheckEmail(value = "abc.com", message = "The email must end abc.com")
    private String email;

    private Map<String, String> departments = new HashMap<>();

    private Map<String, String> carBrands = new HashMap<>();

    private Map<String, String> languagesMap = new HashMap<>();

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

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Map<String, String> getLanguagesMap() {
        return languagesMap;
    }

    public void setLanguagesMap(Map<String, String> languagesMap) {
        this.languagesMap = languagesMap;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                ", carBrand='" + carBrand + '\'' +
                ", languages=" + languages +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    private void fillMaps() {
        this.departments.put("Information Technology", "IT");
        this.departments.put("Human Resources", "HR");
        this.departments.put("Sales", "Sales");

        this.carBrands.put("BMW", "BMW");
        this.carBrands.put("AUDI", "AUDI");
        this.carBrands.put("Mercedes-Benz", "MB");

        this.languagesMap.put("English", "EN");
        this.languagesMap.put("Russian", "RU");
        this.languagesMap.put("French", "FR");
    }
}
