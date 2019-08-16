package com.test02;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
		
		MemberInfo obj = (MemberInfo) factory.getBean("member");
		int num = (int) (Math.random()*2);
		if (num == 0) {
			String message = factory.getMessage("title", null, "기본 메세지", Locale.getDefault());
			System.out.println(message);
			obj.display(Locale.getDefault());
		} else {
			String message = factory.getMessage("title", null, "defaultMessage", Locale.ENGLISH);
			System.out.println(message);
			obj.display(Locale.ENGLISH);
		}
	}
}
