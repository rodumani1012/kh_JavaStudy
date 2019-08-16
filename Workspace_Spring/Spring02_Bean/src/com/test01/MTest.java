package com.test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test01/applicationContext.xml");
		
		MessageBean bean01 = (MessageBean) factory.getBean("peach");
		bean01.sayHello();
		
		MessageBean bean02 = (MessageBean) factory.getBean("pineapple");
		bean02.sayHello();
		
		MessageBean bean03 = (MessageBean) factory.getBean("apple");
		bean03.sayHello();
		
		// factory 객체 닫기 ClassPathXmlApplicationContext 로 형변환 후 close
		((ClassPathXmlApplicationContext)factory).close();
	}
}
