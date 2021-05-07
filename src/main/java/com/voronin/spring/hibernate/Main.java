package com.voronin.spring.hibernate;

import com.voronin.spring.hibernate.entity.Details;
import com.voronin.spring.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Details.class)
                .buildSessionFactory();

        Session session = null;

        try {
            session = sessionFactory.getCurrentSession();
//            Employee employee = new Employee("Max", "Vasilev", "IT", 690);
//            Details details = new Details("London", "12432111135", "max@max.ru");
//            employee.setDetails(details);
//            details.setEmployee(employee);

            session.beginTransaction();
//            session.save(details);

            Details details = session.get(Details.class, 3);
//            System.out.println(details.getEmployee());

            session.delete(details);

            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
            sessionFactory.close();
        }
    }
}
