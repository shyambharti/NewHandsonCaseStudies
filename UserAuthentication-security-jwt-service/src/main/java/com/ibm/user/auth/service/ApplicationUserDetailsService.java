package com.ibm.user.auth.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ibm.user.auth.domain.AuthUserRequest;
import com.ibm.user.auth.domain.User;
import com.ibm.user.auth.dto.OrderDTO;
import com.ibm.user.auth.dto.ProdOrder;
import com.ibm.user.auth.dto.Product;
import com.ibm.user.auth.repository.UserRepository;

import com.ibm.user.auth.client.*;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {
	
	
final RestClient restClient;
	
	@Autowired
	public ApplicationUserDetailsService(com.ibm.user.auth.client.RestClient restClient) {
		this.restClient=restClient;
	}
	
	@Autowired
	UserRepository repository;
	
	@Autowired
	AuthUserRequest authUserRequest;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		User user=repository.findByUsername(username);
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
	}

	public ResponseEntity<Product> getProduct(String prodname){
		
		return restClient.getProduct(prodname);
	}
	
	
	public ResponseEntity<List<OrderDTO>> getOrders(String username){
		
		return  restClient.getOrders(username);
	}
	
	
	public ResponseEntity<ProdOrder> createOrder(String prodname,int quantity,String username) {
		
		return restClient.createOrder(prodname, quantity,username);
	}

}
