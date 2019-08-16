package com.test02;

public class MTest {

	public static void main(String[] args) {
		MessageBean bean01 = new MessageBeanImpl_ko();
		bean01.sayHello("스프링");
		
		MessageBean bean02 = new MessageBeanImpl_en();
		bean02.sayHello("Spring");
	}
}
