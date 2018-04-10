package com.example.webService.RestFullService.Filtering;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;


@RestController
public class FilteringController {
	
	@GetMapping("/filterBean")
	public MappingJacksonValue retriveFilteringBean(){
		FilteringBean filteringBean=new FilteringBean("Ravinder", "lavanya", "8754456333");
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("userName","password");
		FilterProvider fProvider=new SimpleFilterProvider().addFilter("Filter",filter);
		MappingJacksonValue jasValue=new MappingJacksonValue(filteringBean);
		jasValue.setFilters(fProvider);
		return jasValue;
		
	}
	
	@GetMapping("/filter-List")
	public MappingJacksonValue retriveAllFilters(){
		List<FilteringBean> fList=new ArrayList<>();
	fList.add(new FilteringBean("Raju", "Raju123", "23423535"));
	fList.add(new FilteringBean("Hol", "HOL3242", "675675"));
	fList.add(new FilteringBean("TEZ", "TES987", "568568"));
	fList.add(new FilteringBean("JEB", "JEB96", "56856857"));
	
	//Create the SimpleBeanPropertyFilter class with filtered option (Domain Class fieldNmaes)
	SimpleBeanPropertyFilter filter= SimpleBeanPropertyFilter.filterOutAllExcept("mobileNo");
	//create FilterProvide object with one unique id and SimpleBeanPropertyFilter Object
	FilterProvider fFilter=new SimpleFilterProvider().addFilter("Filter", filter);
	//Create MappingJacksonValue object with respective  object
	MappingJacksonValue jsValue=new MappingJacksonValue(fList);
	//add FilterProvider to MappingJacksonValue
	jsValue.setFilters(fFilter);
	return jsValue;
	}

}
