package com.ibm.user.prod.ord.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.user.prod.ord.domain.ProdOrder;
import com.ibm.user.prod.ord.domain.Product;
import com.ibm.user.prod.ord.dto.OrderDTO;
import com.ibm.user.prod.ord.repository.OrderRepository;
import com.ibm.user.prod.ord.repository.ProductRepository;

@Service
public class ProductOrderService {
	
	@Autowired
	ProductRepository prodRepository;
	
	@Autowired
	OrderRepository orderRepository;

	public Product getProductByName(String productname) {
		
		Optional<Product> product=prodRepository.findByProdname(productname);
		return product.get();
	}
	
	public Double getRateProductByName(String productname) {
		
		Optional<Product> product=prodRepository.findByProdname(productname);
		return product.get().getRate();
	}
	
	public ProdOrder createOrder(OrderDTO dto) {
		
		Optional<Product> product=prodRepository.findByProdname(dto.getProdname());
		Double rate= product.get().getRate();
		
		ProdOrder order=new ProdOrder();
		order.setProdname(dto.getProdname());
		order.setQuantity(dto.getQuantity());
		order.setProdcost(rate*dto.getQuantity());
		order.setUsername(dto.getUsername());
		orderRepository.saveAndFlush(order);
		
		return order;
	}
	
	
public ProdOrder createOrder(String prodname,int quantity,String username) {
		
		Optional<Product> product=prodRepository.findByProdname(prodname);
		Double rate= product.get().getRate();
		
		ProdOrder order=new ProdOrder();
		order.setProdname(prodname);
		order.setQuantity(quantity);
		order.setProdcost(rate*quantity);
		order.setUsername(username);
		orderRepository.saveAndFlush(order);
		
		return order;
	}
	
	
	public List<OrderDTO> getOrders(String username){
		
		List<ProdOrder> orders=orderRepository.findAll();
		List<OrderDTO> orderDTOs=new ArrayList<OrderDTO>();
		OrderDTO dto=null;
		for(ProdOrder order:orders) {
			 dto=new OrderDTO();
			if(order.getUsername().equalsIgnoreCase(username)) {
				dto.setId(order.getId());
				dto.setProdname(order.getProdname());
				dto.setProdcost(order.getProdcost());
				dto.setQuantity(order.getQuantity());
				dto.setUsername(order.getUsername());
				orderDTOs.add(dto);
			}
		}
		
		return orderDTOs;
	}
	
}
