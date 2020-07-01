package com.ibm.user.prod.ord.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name="prodorder")
@Entity
public class ProdOrder{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="prodname")
	private String prodname;
	
	@Column(name="prodcost")
	private Double prodcost;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="username")
	private String username;

		public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProdname() {
		return prodname;
	}

	public void setProdname(String prodname) {
		this.prodname = prodname;
	}

	public Double getProdcost() {
		return prodcost;
	}

	public void setProdcost(Double prodcost) {
		this.prodcost = prodcost;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


}
