package com.shopping.app.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.app.exception.SequenceException;
import com.shopping.app.model.Order;
import com.shopping.app.model.Product;
import com.shopping.app.repository.OrderRepo;
import com.shopping.app.repository.ProductRepo;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductRepo repo;
	@Autowired
	private OrderRepo repore;
	
	@PostMapping("/add")
	public String addOrder(@RequestBody Product product){
		repo.save(product);
		return "Product " + product.getName() + " successfuly added !";
	}
	@GetMapping("/getAll")
	public List<Product> getProducts() {
		return repo.findAll();
	}
	
//	@GetMapping("/find/{query}")
//	public ResponseEntity<?> search(@PathVariable("query") String query) {
//		System.out.println(query);
//		Order order= repore.findOrder(principal.));
//		this.repo.findProduct(query, principal);
//		return new Res();
//	}
	
	
	


	
	
}
