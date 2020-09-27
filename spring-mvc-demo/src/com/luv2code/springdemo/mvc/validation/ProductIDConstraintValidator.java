package com.luv2code.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ProductIDConstraintValidator implements ConstraintValidator<ProductID , String>{

	private String productPrefix;

	@Override
	public void initialize(ProductID productID) {

		productPrefix=productID.value();		
	}


	@Override
	public boolean isValid(String code, ConstraintValidatorContext constraintValidatorContext) {

		boolean result;

		if(code!=null) {

			result = code.startsWith(productPrefix);
		}
		else 
		{
			result=true;
		}

		return result;
	}



}
