package com.shopping.app.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.app.exception.API_requestException;
import com.shopping.app.exception.SequenceException;
import com.shopping.app.model.Order;
import com.shopping.app.repository.OrderRepo;
import com.shopping.app.repository.SequenceDao;
import com.shopping.app.service.OrderService;
import com.shopping.app.service.SequenceDeoImpl;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderRepo repo;
//	@Autowired
//	private OrderService service;
	@Autowired
	private SequenceDeoImpl sequence;

	@PostMapping("/add")
	public String addOrder(@RequestBody Order order) throws SequenceException  {
		long sequenceid = sequence.getNextSequenceId("hosting");
    	System.out.println("*********" + sequenceid + "********");
    	order.setId(sequenceid);
		order.setOrderStatus("Pending");
		repo.save(order);
		return "Order id " + order.getId() + " successfuly added !";
	}

	@GetMapping("/getAll")
	public List<Order> getOrder() {
		return repo.findAll();
	}

	@GetMapping("/getById/{id}")
	public Optional<Order> getOrder(@PathVariable Long id) {
		return repo.findById(id);
	}
	
	@GetMapping("/getPending")
	public List<Order> getPending() {
		return repo.findAll().stream().filter(x->x.getOrderStatus().contains("Pending")).collect(Collectors.toList());
	}
	
	@GetMapping("/getCancel")
	public List<Order> getCancelled() {
		return repo.findAll().stream().filter(x->x.getOrderStatus().contains("Cancelled")).collect(Collectors.toList());
	}
	@GetMapping("/getComplete")
	public List<Order> getCompleted() {
		return repo.findAll().stream().filter(x->x.getOrderStatus().contains("Completed")).collect(Collectors.toList());
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Order> updateBook(@PathVariable Long id , @RequestBody Order orderid){
		Order existing=repo.findById(id).orElseThrow(() -> new API_requestException("Order with id : " +id+ " not found,update failed"));
		existing.setOrderStatus(orderid.getOrderStatus());
		existing.setPaymentInfo(orderid.getPaymentInfo());
		existing.setShippingAddress(orderid.getShippingAddress());
		Order update= repo.save(existing);
		return ResponseEntity.ok(update);
	}
	
	@PutMapping("/cancel/{id}")
	public ResponseEntity<Order> orderCancel(@PathVariable long id) {
		Order exist=repo.findById(id).orElseThrow(()-> new API_requestException("Order with id : " +id+ " not found,update failed"));
		exist.setOrderStatus("Cancelled");
		Order cancel=repo.save(exist);
		return ResponseEntity.ok(cancel);
	}
	
	@PutMapping("/complete/{id}")
	public ResponseEntity<Order> orderComplet(@PathVariable long id) {
		Order exist=repo.findById(id).orElseThrow(()-> new API_requestException("Order with id : " +id+ " not found,update failed"));
		exist.setOrderStatus("Completed");
		Order done=repo.save(exist);
		return ResponseEntity.ok(done);
	}
	
	@DeleteMapping("/delet/{id}")
	public String deletePet(@PathVariable long id) {
		repo.deleteById(id);
		return "Deleted Successfully id : " + id;
	}
//	@PutMapping("/{id}")
//  public ResponseEntity<Order> update(@PathVariable Long id, @RequestBody Order orderid) {
//      Order update = service.update(id, orderid);
//      if (update != null) {
//          return ResponseEntity.ok(update);
//      } else {
//          return ResponseEntity.notFound().build();
//      }
//  }
}
