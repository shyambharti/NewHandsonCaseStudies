package com.ibm.user.prod.ord.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.user.prod.ord.domain.ProdOrder;
import com.ibm.user.prod.ord.domain.Product;
import com.ibm.user.prod.ord.dto.OrderDTO;
import com.ibm.user.prod.ord.service.ProductOrderService;

@RestController
public class ProductOrderController {
	
	@Autowired
	ProductOrderService service;
	
	@GetMapping("product/{prodname}")
	public ResponseEntity<Product> getProduct(@PathVariable(value="prodname") String prodname){
		
		return ResponseEntity.ok().body(service.getProductByName(prodname));
	}
	
	@GetMapping("productRate/{prodname}")
	public ResponseEntity<Double> getProductRate(@PathVariable(value="prodname") String prodname){
		
		return ResponseEntity.ok().body(service.getRateProductByName(prodname));
	}
	
	@PostMapping("createOrder")
	public ResponseEntity<ProdOrder> createOrder(@RequestBody OrderDTO orderDTO){
		
		return ResponseEntity.ok().body(service.createOrder(orderDTO));
	}
	
	@GetMapping("productOrder/{username}")
	public ResponseEntity<List<OrderDTO>> getOrders(@PathVariable(value="username") String username){
		
		
		return ResponseEntity.ok().body(service.getOrders(username));
	}
	
	@GetMapping("createOrder/{prodname}/{quantity}/{username}")
	public ResponseEntity<ProdOrder> createOrder(@PathVariable(value="prodname") String prodname,@PathVariable(value="quantity") int quantity,@PathVariable(value="username") String username){
		
		return ResponseEntity.ok().body(service.createOrder(prodname,quantity,username));
	}
}
