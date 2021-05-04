package com.voronin.spring.aop.models;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class University {

    private final List<Student> students = new ArrayList<Student>();

    public void addStudent() {
        Student s1 = new Student("Alex", "Golovin", 3, 8.3);
        Student s2 = new Student("Garry", "Solovey", 2, 7.9);
        Student s3 = new Student("Diana", "Malaxova", 5, 9.6);
        this.students.add(s1);
        this.students.add(s2);
        this.students.add(s3);
    }

    public List<Student> getStudents() {
        System.out.println("Information from method getStudents:");
        System.out.println(students);
        return this.students;
    }
}
