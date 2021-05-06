package com.voronin.spring.hibernate;

import com.voronin.spring.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session;
        Employee employee;

        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

//            employee = session.get(Employee.class, 4);
//            employee.setSalary(employee.getSalary() + 1000);

            session.createQuery("update Employee set salary = 1000 where name = 'Alexander'").executeUpdate();

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
