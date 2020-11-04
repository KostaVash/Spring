package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopDeclarations {
	//this is where we add all of our related advices for logging 

	@Pointcut("execution(* com.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}

	//create pointcut declreation for getter methods
	@Pointcut("execution(* com.aopdemo.dao.*.get*(..))")
	public void getter() {}
	
	//create pointcut declreation for setter methods
	@Pointcut("execution(* com.aopdemo.dao.*.set*(..))")
	public void setter() {}
	
	//create pointcut include package but exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterAndSetter() {}
}
