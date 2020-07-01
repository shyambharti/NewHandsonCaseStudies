package com.ibm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.dto.ConvertCurrencyDTO;
import com.ibm.service.ConvertCurrencyService;


@RestController
public class ConvertCurrencyController {
	
	@Autowired
	ConvertCurrencyService service;
	
	@GetMapping("convertedCurrency/from/{from}/to/{to}/amount/{amount}")
	public ResponseEntity<ConvertCurrencyDTO> getcoversionfactorbyfromToto(@PathVariable String from,@PathVariable String to,@PathVariable Double amount){
		
		return ResponseEntity.ok().body(service.getcoversionfactorbyfromToto(from, to, amount));
	}
}
