package com.klef.jfsd.exam.Service;
import jakarta.persistence.criteria.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.exam.model.Customer;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Customer> findCustomersByAgeGreaterThan(int age) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Customer> query = builder.createQuery(Customer.class);
            Root<Customer> root = query.from(Customer.class);

            query.select(root).where(builder.gt(root.get("age"), age));

            Query<Customer> q = session.createQuery(query);
            return q.getResultList();
        }
    }

    public List<Customer> findCustomersByLocationLike(String location) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Customer> query = builder.createQuery(Customer.class);
            Root<Customer> root = query.from(Customer.class);

            query.select(root).where(builder.like(root.get("location"), "%" + location + "%"));

            Query<Customer> q = session.createQuery(query);
            return q.getResultList();
        }
    }
}
