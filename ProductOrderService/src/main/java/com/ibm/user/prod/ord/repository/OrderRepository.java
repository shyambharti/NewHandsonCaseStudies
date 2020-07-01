package com.ibm.user.prod.ord.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.user.prod.ord.domain.ProdOrder;

public interface OrderRepository extends JpaRepository<ProdOrder, Long>{
	
}
