package com.ibm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.domain.CurrencyConversion;
import com.ibm.dto.CurrencyConversionDTO;
import com.ibm.service.CurrencyConversionService;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	CurrencyConversionService service;

	
	@GetMapping("currency/{countryfrom}")
	public ResponseEntity<CurrencyConversionDTO> searchByCountryfrom(@PathVariable(value="countryfrom") String countryfrom){
		
		if(service.findConversionByCountryfrom(countryfrom)==null) {
			
			return new ResponseEntity<CurrencyConversionDTO>(service.findConversionByCountryfrom(countryfrom),HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<CurrencyConversionDTO>(service.findConversionByCountryfrom(countryfrom),HttpStatus.OK);
	}
	
	@GetMapping("conversionfactor")
	public ResponseEntity<List<CurrencyConversion>> getconversionFactor(){
		
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@PostMapping("addconversionfactor")
	public ResponseEntity addconversionfactor(@RequestBody CurrencyConversion cc) {
		CurrencyConversion savecc=	service.addConversionfactor(cc);
		if(savecc.getId()==null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@PutMapping("countryfrom")
	public ResponseEntity<CurrencyConversion> updateConversionFactor(@RequestParam(value="countryfrom") String countryfrom ,@RequestBody CurrencyConversionDTO dto) {
		
		
		
		return new ResponseEntity<>(service.updateConversionFactor(countryfrom,dto),HttpStatus.OK);
	}
	
	@GetMapping("conversionfactor/from/{from}/to/{to}")
	public ResponseEntity<CurrencyConversionDTO> getcoversionfactorbyfromToto(@PathVariable String from,@PathVariable String to){
	
		return ResponseEntity.ok().body(service.getConversionfactorFromToto(from,to));
	}
	
	@GetMapping("/currencyConversionRate/from/{from}/to/{to}")
	public ResponseEntity<Double> getRate(@PathVariable(value="from") String from,@PathVariable(value="to") String to) {
	
		return ResponseEntity.ok().body(service.getRate(from, to));
	}
	

}
