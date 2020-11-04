package com.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aopdemo.dao.AccountDAO;
import com.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		
		//read spring config java class 
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		AccountDAO theAccount = context.getBean("accountDAO",AccountDAO.class);
		
		MembershipDAO themember =context.getBean("membershipDAO",MembershipDAO.class);
		
		//call the business method 
		Account myAccount=new Account();
		myAccount.setLevel("VIP");
		myAccount.setName("Uri");
		
		theAccount.addAccount(myAccount);
		theAccount.doWork();
		
		//call the accountdao getter/setter methods
		
		theAccount.setName("Vova");
		theAccount.setServiceCode("Very-High");
		
		System.out.println(theAccount.getName());
		System.out.println(theAccount.getServiceCode());
		
		//call from membership
		themember.addAccount();
		themember.goToSleep();
		
		//close context
		context.close();
	}

}
