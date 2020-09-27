package com.luv2code.springdemo.mvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


//how we validate 
@Constraint(validatedBy = ProductIDConstraintValidator.class)
//where we can apply it 
@Target({ElementType.METHOD, ElementType.FIELD})
//where it's saved
@Retention(RetentionPolicy.RUNTIME)
public @interface ProductID {
	
	//define default product id 
	public String value() default "IDX";
	//define default error message
	public String message() default "must start with IDX";
	//define default groups
	public Class<?>[] groups() default {};
	//define default payloads
	public Class<? extends Payload>[] payload() default{};
}
