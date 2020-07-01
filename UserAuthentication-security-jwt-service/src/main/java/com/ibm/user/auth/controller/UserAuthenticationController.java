package com.ibm.user.auth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.user.auth.domain.AuthUserRequest;
import com.ibm.user.auth.dto.OrderDTO;
import com.ibm.user.auth.dto.ProdOrder;
import com.ibm.user.auth.dto.Product;
import com.ibm.user.auth.service.ApplicationUserDetailsService;
import com.ibm.user.auth.util.JwtUtil;

@RestController
public class UserAuthenticationController {

	@Autowired
	JwtUtil jwtUtil;

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	ApplicationUserDetailsService service;


	@GetMapping("/")
	public String getHome() {

		return "<h1>Welcome </h1>";
	}
	
	@GetMapping("product/{prodname}")
	public ResponseEntity<Product> getProduct(@PathVariable(value="prodname") String prodname){
		
		return service.getProduct(prodname);
	}
	
	@GetMapping("productOrder/{username}")
	public ResponseEntity<List<OrderDTO>> getOrders(@PathVariable(value="username") String username){
		
		
		return service.getOrders(username);
	}
	
	@GetMapping("createOrder/{prodname}/{quantity}/{username}")
	public ResponseEntity<ProdOrder> createOrder(@PathVariable(value="prodname") String prodname,@PathVariable(value="quantity") int quantity,@PathVariable(value="username") String username){
		
		return service.createOrder(prodname, quantity,username);
	}


	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthUserRequest authUserRequest) throws Exception {

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authUserRequest.getUsername(),
					authUserRequest.getPassword()));
		} catch (Exception ex) {
			throw new Exception("Invalide Username/Password");
		}
		System.out.println("token:" + jwtUtil.generateToken(authUserRequest.getUsername()));

		return jwtUtil.generateToken(authUserRequest.getUsername());
	}

}
