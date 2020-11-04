package com.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;
	
	//add a new method :findAccounts()
	public List<Account> findAccounts(boolean tripWire){
		
		//simulating an exception
		if (tripWire) {
			throw new RuntimeException("Well, you did something Wrong");
		}
		
		List<Account> myAccounts = new ArrayList<>();
		
		//create sample accounts 
		Account temp1= new Account("Jhon","Vipp");
		Account temp2= new Account("Ron","Gold");
		Account temp3= new Account("Moshe","Silver");
		Account temp4= new Account("Victor","Arad");
		Account temp5= new Account("Yaffa","Steel");
		//add them to the list
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
		myAccounts.add(temp4);
		myAccounts.add(temp5);
		
		return myAccounts;
		
	}

	public void addAccount(Account theAccount) {

		System.out.println(getClass()+": Doing my DB work: ADDING AN ACCOUNT");

	}

	public boolean doWork() {

		System.out.println(getClass()+": doWork()");

		return false;
	}

	public String getName() {
		System.out.println(getClass()+": in getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass()+": in setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass()+": in getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass()+": in setServiceCode()");
		this.serviceCode = serviceCode;
	}

}
