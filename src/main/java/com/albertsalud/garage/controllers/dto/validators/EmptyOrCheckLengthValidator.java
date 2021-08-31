package com.albertsalud.garage.controllers.dto.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmptyOrCheckLengthValidator implements ConstraintValidator<EmptyOrCheckLength, Object> {
	
	private Integer minLength;
	private Integer maxLength;
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		if(value == null || value.toString().trim().equals("")) return true;
		if(minLength != null && value.toString().length() < minLength) return false;
		if(maxLength != null && value.toString().length() > maxLength) return false;
		
		return true;
	}

}

