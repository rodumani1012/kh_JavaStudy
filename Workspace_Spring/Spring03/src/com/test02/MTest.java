package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
		
		BirthDto park = (BirthDto) factory.getBean("park");
		System.out.println(park);
		
		BirthDto one = (BirthDto) factory.getBean("one");
		System.out.println(one);
		
		BirthDto choi = (BirthDto) factory.getBean("choi");
		System.out.println(choi);
	}
}
