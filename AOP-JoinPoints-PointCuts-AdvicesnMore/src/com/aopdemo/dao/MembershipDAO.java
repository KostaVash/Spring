
package com.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public void addAccount() {
		System.out.println(getClass()+" : Doing Stuff : Adding a memebership Account");
	}
	
	public void goToSleep() {
		
		System.out.println(getClass()+" : goToSleep()");
	}

}
