package com.test02;

public class MessageBeanImpl_ko implements MessageBean {

	@Override
	public void sayHello(String name) {
		System.out.println("안녕하세요, " + name);
	}

}
