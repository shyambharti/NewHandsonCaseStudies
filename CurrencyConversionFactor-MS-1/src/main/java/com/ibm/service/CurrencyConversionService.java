package com.ibm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.domain.CurrencyConversion;
import com.ibm.dto.CurrencyConversionDTO;
import com.ibm.dto.CurrencyConversionMapper;
import com.ibm.repository.CurrencyConversionRepository;

@Service
public class CurrencyConversionService {
	
	private static Logger logger= LoggerFactory.getLogger(CurrencyConversionService.class);
	
	@Autowired
	CurrencyConversionRepository repository;
	
	public CurrencyConversionDTO getCurrencyConversionById(Long id) {
		CurrencyConversionDTO dto=new CurrencyConversionDTO();
		CurrencyConversionMapper mapper=new CurrencyConversionMapper();
		Optional<CurrencyConversion> cc=repository.findById(id);
		dto=mapper.covertCurrencyConversionToCurrencyConversionDTO(cc.get());
		
		
		return dto;
	}
	
	
	public CurrencyConversionDTO findConversionByCountryto(String countryCode) {
		CurrencyConversionDTO dto=new CurrencyConversionDTO();
		CurrencyConversionMapper mapper=new CurrencyConversionMapper();
		CurrencyConversion cc=repository.findByCountryto(countryCode);
		dto=mapper.covertCurrencyConversionToCurrencyConversionDTO(cc);
		
		
		return dto;
	}

	public CurrencyConversionDTO findConversionByCountryfrom(String countryCode) {
		CurrencyConversionDTO dto=new CurrencyConversionDTO();
		CurrencyConversionMapper mapper=new CurrencyConversionMapper();
		CurrencyConversion cc=repository.findByCountryfrom(countryCode);
		dto=mapper.covertCurrencyConversionToCurrencyConversionDTO(cc);
		return dto;
	}
	
	public List<CurrencyConversion> findAll(){
		
		List<CurrencyConversion> list=repository.findAll();
		
		return list;
	}
	
	public CurrencyConversion addConversionfactor(CurrencyConversion cc) {
		
		repository.saveAndFlush(cc);
		logger.info("Successfully save conversion factor");
		return cc;
	}
	
	public CurrencyConversion updateConversionFactor(String countryfrom,CurrencyConversionDTO dto) {
	
		CurrencyConversion cc=repository.findByCountryfrom(countryfrom);
		
		cc.setCurrencyfactor(dto.getCurrencyfactor());
		
		repository.save(cc);
		logger.info("Successfully updated conversion factor");
		return cc;
	}
	
	public CurrencyConversionDTO getConversionfactorFromToto(String from,String to) {
		CurrencyConversionDTO dto=new CurrencyConversionDTO();
		Map<String,String> hm=new HashMap<String,String>();
		hm.put("countryfrom",from);
		hm.put("countryto", to);
		CurrencyConversionMapper mapper=new CurrencyConversionMapper();
	
		List<CurrencyConversion> cc=repository.findAll();
		for(CurrencyConversion newCC:cc) {
			if(newCC.getCountryfrom().equalsIgnoreCase(from) && newCC.getCountryto().equalsIgnoreCase(to)) {
				dto=mapper.covertCurrencyConversionToCurrencyConversionDTO(newCC);
				break;
			}
		}
		logger.info("Conversion factor from country to to country");
		return dto;
	}
	
	public Double getRate(String from,String to) {
	Double rate=null;
		List<CurrencyConversion> cc=repository.findAll();
		for(CurrencyConversion newCC:cc) {
			if(newCC.getCountryfrom().equalsIgnoreCase(from) && newCC.getCountryto().equalsIgnoreCase(to)) {
			rate=newCC.getCurrencyfactor();
				break;
			}
		}
		logger.info("Rate for service MS-2"+rate);
		return rate;
	}
}
