package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyApiAnalyticsAspect {
	
	@Before("com.aopdemo.aspect.AopDeclarations.forDaoPackageNoGetterAndSetter()")
	public void preformApiAnalytics() {
		System.out.println("\n=====>>>2 Performing API analytics");

	}


}
