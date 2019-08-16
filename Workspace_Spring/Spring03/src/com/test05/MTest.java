package com.test05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test05/applicationContext.xml");
		
		Engineer kang = (Engineer) factory.getBean("kang");
		Developer yu = (Developer) factory.getBean("yu");
		
		System.out.println(kang);
		System.out.println(yu);
	}
}
