package com.ibm.convertCurrencyServiceClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("currency-conversion-service")
public interface RestClient {
	
	@GetMapping("/currencyConversionRate/from/{from}/to/{to}")
	public Double getRate(@PathVariable(value="from") String from,@PathVariable(value="to") String to);

}
