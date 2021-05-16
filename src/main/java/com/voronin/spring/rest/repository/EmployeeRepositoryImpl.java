package com.voronin.spring.rest.repository;

import com.voronin.spring.rest.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final SessionFactory sessionFactory;

    public EmployeeRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Employee> getEmployees() {
        Session session = this.sessionFactory.getCurrentSession();
        Query<Employee> query = session.createQuery("from Employee", Employee.class);
        return query.getResultList();
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session = this.sessionFactory.getCurrentSession();
        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.get(Employee.class, id);
    }

    @Override
    public void deleteEmployee(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        session.createQuery("delete from Employee where id=:id")
                .setParameter("id", id)
                .executeUpdate();
    }
}
