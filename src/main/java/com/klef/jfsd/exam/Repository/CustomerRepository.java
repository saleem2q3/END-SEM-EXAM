package com.klef.jfsd.exam.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klef.jfsd.exam.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}