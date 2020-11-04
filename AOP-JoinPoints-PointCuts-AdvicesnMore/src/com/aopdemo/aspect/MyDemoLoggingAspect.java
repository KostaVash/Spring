package com.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.aopdemo.Account;

@Aspect
@Component
@Order(1)		
public class MyDemoLoggingAspect {
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Around("execution(* com.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable{ 

		//print out method we are advising 
		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n=======>>>> Executing @Around on method : "+method);
		
		//get begin timestamp
		long begin = System.currentTimeMillis();
		Object result = null;
		
		try {
			
		//now' lets execute the method 
		 result = theProceedingJoinPoint.proceed();
		 
		 }
		catch(Exception e) {
			//log the exception
			myLogger.warning(e.getMessage());
			//give user a custom message
			result = "Major accident! but chill we got you man, your private AOP heli is on the way! ";
			//or if we want to rethrow we can do this too 
			//throw e;
		}

		// get end timestamp
		long end = System.currentTimeMillis();
		//compute duration and display it
		long duration = end - begin;
		myLogger.info("\n=======>>>>It took us "+duration/1000.0+" seconds");
		
		return result;
	}
	
	
	@After("execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
		
				//print out which method we are addvising on
				String method = joinPoint.getSignature().toShortString();
				myLogger.info("\n=======>>>> Executing @After(Finally) on method : "+method);
	}
	
	
	
	@AfterThrowing(pointcut = "execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing = "theExc")
	public void afterThrowingFindAccountAdvice(JoinPoint joinPoint,Throwable theExc) {
		
		//print out which method we are addvising on
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("\n=======>>>> Executing @AfterThrowing on method : "+method);
		
		//log the exception
		myLogger.info("\n=======>>>> The exception is : "+theExc);
		
	}
	
	
	//@AfterReturning
	//add a new advice for @afterReturning on the find accounts method
	@AfterReturning(pointcut = "execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning = "result"
			)
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
		
		//print out which method we are advising on 
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("\n=======>>>> Executing @AfterReturning on method : "+method);

		//print out the result of the method call
		myLogger.info("\n=======>>>> result is  : \n"+result);
		
		//let's post-process the data 
		
		//convert the account names to uppercases 
		convertAccountNamesToUpperCase(result);
		
		myLogger.info("\n=======>>>> result is  : \n"+result);
		
	}

	
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		//loop through accounts
		for(Account temp : result) {
			
		//get uppercase version of name 
			String theUpperName = temp.getName().toUpperCase();
			
		//update the name on the account
			temp.setName(theUpperName);
		}
	}



	//@before advice
	@Before("com.aopdemo.aspect.AopDeclarations.forDaoPackageNoGetterAndSetter()")
	//@Before("execution(public void add*(com.aopdemo.Account))")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {

		myLogger.info("\n=====>>>1 Executing @before advice on addAccount()");
		//display the method signature 
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();

		myLogger.info("The Methoed: "+methodSig);

		//display the method arguments 

		//get args
		Object[] args = theJoinPoint.getArgs();

		//loop thru args
		for (Object tempArg: args) {

			myLogger.info(tempArg.toString());
			//if it account print his name and level 
			if(tempArg instanceof Account) {
				//downcast the object to account
				Account theAccount = (Account) tempArg;

				myLogger.info(theAccount.getLevel()+" and "+theAccount.getName());


			}
		}



	}

}
