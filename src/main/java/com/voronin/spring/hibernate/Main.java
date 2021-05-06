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
//            Employee employee = new Employee("Oleg", "Ivanov", "Sales", 700);
//            Details details = new Details("Moscow", "121352135", "Oleg@oleg.ru");
//            employee.setDetails(details);
            session.beginTransaction();

//            session.save(employee);

            Employee employee = session.get(Employee.class, 2);
            session.delete(employee);

            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
            sessionFactory.close();
        }
    }
}
