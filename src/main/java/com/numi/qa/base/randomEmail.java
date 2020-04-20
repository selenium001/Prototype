package com.numi.qa.base;

import java.util.Date;

public class randomEmail {
	public static void main(String[] args) {
		generateRandomEmail();
	}
	
	public static String generateRandomEmail() {
	long time = new Date().getTime();
	String email= "qa"+time+"@gmail.com";
	System.out.println("Generate randome Email:"+email);
	return email;
	
	}


}
