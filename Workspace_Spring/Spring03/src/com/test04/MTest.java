package com.test04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test04/applicationContext.xml");
		
		Engineer kang = (Engineer) factory.getBean("engineer");
		Developer yu = (Developer) factory.getBean("developer");
		
		System.out.println(kang);
		System.out.println(yu);
	}
}
