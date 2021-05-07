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

//            Department department = new Department("Sales", 600, 1200);
//            Employee emp1 = new Employee("Alex", "Ivanov", 900);
//            Employee emp2 = new Employee("Maria", "Smirnova", 1000);
//            Employee emp3 = new Employee("Ivan", "Gorohov", 1300);
//
//            department.addEmployeeToDepartment(emp1);
//            department.addEmployeeToDepartment(emp2);
//            department.addEmployeeToDepartment(emp3);

            session.beginTransaction();

//            session.save(department);

            System.out.println("Get Department!");
            Department department = session.get(Department.class, 4);
            System.out.println("Show Department!");
            System.out.println(department);
            System.out.println("-----------------");

            System.out.println("Show Employees!");
            System.out.println(department.getEmployees());
            System.out.println("-----------------");

            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
            sessionFactory.close();
        }
    }
}
