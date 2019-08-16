package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/applicationContext.xml");
		
		// 프록시 객체가 interface를 기준으로 잡아주기 때문에 Person 클래스로 생성.
		Person m = factory.getBean("man", Person.class);
		Person w = factory.getBean("woman", Person.class);
		
		System.out.println("남학생 입장");
		m.classWork();
		System.out.println("--------------");
		System.out.println("여학생 입장");
		w.classWork();
	}
}
