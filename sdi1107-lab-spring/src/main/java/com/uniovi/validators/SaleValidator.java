package com.uniovi.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.uniovi.entities.Sale;
import com.uniovi.services.SalesService;

@Component
public class SaleValidator implements Validator {
    
	@Autowired
	private SalesService salesService;

	@Override
	public boolean supports(Class<?> aClass) {
		return Sale.class.equals(aClass);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
	}

}
