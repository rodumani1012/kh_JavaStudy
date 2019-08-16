package com.test02;

public class MessageBeanImpl_en implements MessageBean {

	@Override
	public void sayHello(String name) {
		System.out.println("Hello, " + name);
	}

}
