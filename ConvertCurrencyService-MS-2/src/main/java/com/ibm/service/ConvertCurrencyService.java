package com.ibm.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.convertCurrencyServiceClient.RestClient;
import com.ibm.dto.ConvertCurrencyDTO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ConvertCurrencyService {
	private static Logger logger= LoggerFactory.getLogger(ConvertCurrencyService.class);
	
final RestClient restClient;
	
	@Autowired
	public ConvertCurrencyService(RestClient restClient) {
		this.restClient=restClient;
	}
	
	
	@HystrixCommand(fallbackMethod="getcoversionfactorbyfromTotoFallback")
	public ConvertCurrencyDTO getcoversionfactorbyfromToto(String from,String to,Double amount){
		
		Double rate=null;
		rate=restClient.getRate(from, to);
		logger.info("Rate coming from MS-1 service :"+rate);
		ConvertCurrencyDTO dto=new ConvertCurrencyDTO();
			
		dto.setRate(rate);
		
		dto.setCountryfrom(from);
		dto.setCountryto(to);
		dto.setAmount(amount);
		dto.setConvertedAmount(rate*amount);
		
		return dto;
	}

	
	public ConvertCurrencyDTO getcoversionfactorbyfromTotoFallback(String from,String to,Double amount){
		
		Double rate=10.0;
		
		ConvertCurrencyDTO dto=new ConvertCurrencyDTO();
			
		dto.setRate(rate);
		
		dto.setCountryfrom(from);
		dto.setCountryto(to);
		dto.setAmount(amount);
		dto.setConvertedAmount(rate*amount);
		logger.info("called Fallback method for getcoversionfactorbyfromToto");
		return dto;
	}

}
