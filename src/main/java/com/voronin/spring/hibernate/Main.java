package com.voronin.spring.hibernate;

import com.voronin.spring.hibernate.entity.Child;
import com.voronin.spring.hibernate.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;

        try {
            session = sessionFactory.getCurrentSession();

//            Child c1 = new Child("Ylua", 12);
//            Child c2 = new Child("Sasha", 9);
//            Child c3 = new Child("Dima", 13);
//
//            Section s1 = new Section("Dance");
//            s1.addChildToSection(c1);
//            s1.addChildToSection(c2);
//            s1.addChildToSection(c3);

//            Section s1 = new Section("ValleyBall");
//            Section s2 = new Section("Chess");
//            Section s3 = new Section("Math");
//
//            Child child = new Child("Ivan", 7);
//            child.addSectionToChild(s1);
//            child.addSectionToChild(s2);
//            child.addSectionToChild(s3);

            session.beginTransaction();

//            session.persist(s1);
//            session.persist(child);

//            Section section = session.get(Section.class, 2);
//            System.out.println(section);
//            System.out.println("-----------------");
//            System.out.println(section.getChildren());

//            Child child = session.get(Child.class, 7);
//            System.out.println(child);
//            System.out.println("-----------------");
//            System.out.println(child.getSections());

//            Section section = session.get(Section.class, 5);
//            session.delete(section);

            Child child = session.get(Child.class, 7);
            session.delete(child);

            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
            sessionFactory.close();
        }
    }
}
