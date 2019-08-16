package com.test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test01/applicationContext.xml");
		
		NickName nickName = (NickName) factory.getBean("NickName");
		NickNamePrn nickNamePrn = (NickNamePrn) factory.getBean("NickNamePrn");
		
		System.out.println(nickName);
		System.out.println(nickNamePrn);
	}
}
