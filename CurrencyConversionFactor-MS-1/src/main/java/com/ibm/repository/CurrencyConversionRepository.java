package com.ibm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.domain.CurrencyConversion;

public interface CurrencyConversionRepository extends JpaRepository<CurrencyConversion, Long> {
	
	CurrencyConversion findByCountryto(String countryto);
	
	CurrencyConversion findByCountryfrom(String countryfrom);
	
	 List<CurrencyConversion> findAll() ;
	
}
