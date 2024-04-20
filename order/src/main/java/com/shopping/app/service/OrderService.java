package com.shopping.app.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.shopping.app.model.Order;
import com.shopping.app.repository.OrderRepo;

public class OrderService {

	@Autowired
	OrderRepo repo;
	public Order update(Long id, Order orderid) {
        if (repo.existsById(id)) {
            orderid.setId(id);
            return repo.save(orderid);
        }
        return null;
    }
}
