package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyCloudLogAsyncAspect {
	
	@Before("com.aopdemo.aspect.AopDeclarations.forDaoPackageNoGetterAndSetter()")
	public void logToCloudAsync() {
		System.out.println("\n=====>>>3 Logging to Cloud in async fashion");}
}
