package com.voronin.spring.hibernate;

import com.voronin.spring.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session;
        List<Employee> employees;

        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

//            employees = session.createQuery("from Employee").getResultList();
//            employees = session.createQuery("from Employee where department = 'Sales'").getResultList();
//            employees = session.createQuery("from Employee where salary > 730").getResultList();
            employees = session.createQuery("from Employee where department = 'Sales' AND salary > 700").getResultList();
            session.getTransaction().commit();

            for (Employee employee : employees) {
                System.out.println(employee);
            }
        } finally {
            sessionFactory.close();
        }
    }
}
