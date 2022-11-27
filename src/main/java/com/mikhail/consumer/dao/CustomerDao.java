package com.mikhail.consumer.dao;

import com.mikhail.consumer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer, Long> {
}
