package com.voronin.spring.hibernate;

import com.voronin.spring.hibernate.entity.Department;
import com.voronin.spring.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.TempTableDdlTransactionHandling;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;

        try {
            session = sessionFactory.getCurrentSession();

//            Department department = new Department("IT", 300, 1200);
//            Employee emp1 = new Employee("Alex", "Ivanov", 800);
//            Employee emp2 = new Employee("Maria", "Smirnova", 1000);
//
//            department.addEmployeeToDepartment(emp1);
//            department.addEmployeeToDepartment(emp2);

            session.beginTransaction();
//            session.save(department);

//            Department department = session.get(Department.class, 3);
//            System.out.println(department);
//            System.out.println(department.getEmployees());

            Department department = session.get(Department.class, 3);
            session.delete(department);

            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
            sessionFactory.close();
        }
    }
}
