package com.shopping.app.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.shopping.app.model.Order;
import com.shopping.app.model.Product;
@Repository
public interface ProductRepo extends MongoRepository<Product,String>{

//	public List<Product> findProduct(String name,Order order);
}
