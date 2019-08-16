package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
		
		// 프록시 객체가 interface를 기준으로 잡아주기 때문에 Person 클래스로 생성.
		Person m = factory.getBean("man", Person.class);
		Person w = factory.getBean("woman", Person.class);
		
		m.classWork();
		w.classWork();
	}
}
