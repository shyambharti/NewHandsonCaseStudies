package com.ibm.user.auth.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ibm.user.auth.dto.OrderDTO;
import com.ibm.user.auth.dto.ProdOrder;
import com.ibm.user.auth.dto.Product;


@FeignClient("product-order-service")
public interface RestClient {
	
	@GetMapping("product/{prodname}")
	public ResponseEntity<Product> getProduct(@PathVariable(value="prodname") String prodname);
	
	@GetMapping("productOrder/{username}")
	public ResponseEntity<List<OrderDTO>> getOrders(@PathVariable(value="username") String username);
	
	@GetMapping("createOrder/{prodname}/{quantity}/{username}")
	public ResponseEntity<ProdOrder> createOrder(@PathVariable(value="prodname") String prodname,@PathVariable(value="quantity") int quantity,@PathVariable(value="username") String username);

}
