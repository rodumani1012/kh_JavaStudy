package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/applicationContext.xml");
		
		// 다형성 : 부모 타입의 자식 객체를 생성하면 자식 메소드가 실행 된다.
		Emp kang = (Emp) factory.getBean("kang");
		System.out.println(kang);
		
		Emp yu = (Emp) factory.getBean("yu");
		System.out.println(yu);
	}
}
