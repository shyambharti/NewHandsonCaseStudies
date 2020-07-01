package com.ibm.user.auth.dto;

public class OrderDTO {


	private Long id;
	

	private String prodname;
	

	private Double prodcost;
	
	private int quantity;

	private String username;

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


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


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	
}
