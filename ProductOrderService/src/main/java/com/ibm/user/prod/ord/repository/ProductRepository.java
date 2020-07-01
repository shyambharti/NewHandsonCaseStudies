package com.ibm.user.prod.ord.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.user.prod.ord.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	Optional<Product> findByProdname(String prodname);
}
