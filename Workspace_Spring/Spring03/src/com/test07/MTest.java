package com.test07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test07/applicationContext.xml");
		
		TV tv01 = (IgTv) factory.getBean("igTv");
		tv01.powerOn();
		tv01.volumeUp();
		tv01.volumeDown();
		tv01.powerOff();
		
		System.out.println("-------------------------");
		
		TV tv02 = factory.getBean("samsongTv", SamsongTv.class);
		tv02.powerOn();
		tv02.volumeUp();
		tv02.volumeDown();
		tv02.powerOff();
	}
}
