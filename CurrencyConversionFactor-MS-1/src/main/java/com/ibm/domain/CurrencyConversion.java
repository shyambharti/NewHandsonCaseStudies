package com.ibm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="currencyconversion")
@Entity
public class CurrencyConversion {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Long id;
	

	@Column(name="countryfrom")
	private String countryfrom;
	

	@Column(name="countryto")
	private String countryto;
	

	@Column(name="currencyfactor")
	private Double currencyfactor;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public Double getCurrencyfactor() {
		return currencyfactor;
	}

	public void setCurrencyfactor(Double currencyfactor) {
		this.currencyfactor = currencyfactor;
	}

	public String getCountryfrom() {
		return countryfrom;
	}

	public void setCountryfrom(String countryfrom) {
		this.countryfrom = countryfrom;
	}

	public String getCountryto() {
		return countryto;
	}

	public void setCountryto(String countryto) {
		this.countryto = countryto;
	}
	
}
