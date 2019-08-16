package com.test07;

public class MessageBeanImpl implements MessageBean {

	private String name;
	
	@Override
	public void sayHello() {
		try {
			Thread.sleep(3000); // 3초후에
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Hello, " + name);
	}
	
	public void setName(String name) {
		this.name = name;
	}

}
