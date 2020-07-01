package com.ibm.dto;

import com.ibm.domain.CurrencyConversion;

public class CurrencyConversionMapper {

	public CurrencyConversionDTO covertCurrencyConversionToCurrencyConversionDTO(CurrencyConversion cc) {
		CurrencyConversionDTO dto=new CurrencyConversionDTO();
		
		dto.setId(cc.getId());
		dto.setCountryfrom(cc.getCountryfrom());
		dto.setCountryto(cc.getCountryto());
		dto.setCurrencyfactor(cc.getCurrencyfactor());
		
		return dto;
	}
	
}
