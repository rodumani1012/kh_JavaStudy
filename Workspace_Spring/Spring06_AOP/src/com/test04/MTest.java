package com.test04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test04/applicationContext.xml");
		
		Person m = (Person) factory.getBean("man");
		Person w = (Person) factory.getBean("woman");
		
		System.out.println("남자 입장");
		m.classWork();
		System.out.println("----------------");
		System.out.println("여자 입장");
		w.classWork();
	}
}
