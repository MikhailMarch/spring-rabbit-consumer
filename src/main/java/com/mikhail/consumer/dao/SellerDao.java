package com.mikhail.consumer.dao;

import com.mikhail.consumer.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerDao extends JpaRepository<Seller, Long> {
}
