package com.albertsalud.garage.controllers.dto.validators;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = EmptyOrCheckLengthValidator.class)
@Target(ElementType.FIELD)
@Retention(RUNTIME)
public @interface EmptyOrCheckLength {
	String message() default "Field must be empty or ";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
	
	int minLength();	
	int maxLength();	// The name of the repeated password field
}
