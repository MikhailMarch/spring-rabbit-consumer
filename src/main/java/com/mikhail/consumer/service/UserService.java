package com.mikhail.consumer.service;

import com.mikhail.consumer.dao.CustomerDao;
import com.mikhail.consumer.dao.SellerDao;
import com.mikhail.consumer.model.Customer;
import com.mikhail.consumer.model.Seller;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final CustomerDao customerDao;
    private final SellerDao sellerDao;

    public void saveCustomer(String name) {
        customerDao.save(Customer.of(name));
    }

    public void saveSeller(String name) {
        sellerDao.save(Seller.of(name));
    }
}
