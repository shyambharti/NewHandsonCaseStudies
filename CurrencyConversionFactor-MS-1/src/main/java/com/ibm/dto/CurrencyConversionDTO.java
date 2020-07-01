package com.ibm.dto;

public class CurrencyConversionDTO {


	private Long id;


	private String countryfrom;
	

	private String countryto;
	

	private Double currencyfactor;
	
	public Long getId() {
		return id;
	}


	public String getCountryfrom() {
		return countryfrom;
	}


	public String getCountryto() {
		return countryto;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public void setCountryfrom(String countryfrom) {
		this.countryfrom = countryfrom;
	}


	public void setCountryto(String countryto) {
		this.countryto = countryto;
	}


	public Double getCurrencyfactor() {
		return currencyfactor;
	}


	public void setCurrencyfactor(Double currencyfactor) {
		this.currencyfactor = currencyfactor;
	}


	
	
}
