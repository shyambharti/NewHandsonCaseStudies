package com.ibm.dto;

public class ConvertCurrencyDTO {


	private String countryfrom;
	

	private String countryto;
	

	private Double amount;
	
	private Double rate;
	
	private Double convertedAmount;

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

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public Double getConvertedAmount() {
		return convertedAmount;
	}

	public void setConvertedAmount(Double convertedAmount) {
		this.convertedAmount = convertedAmount;
	}
}
