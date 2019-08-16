package com.test01;

public class MessageBeanImpl implements MessageBean {

	private String fruit;
	private int cost;
	
	public MessageBeanImpl() {
		this.fruit = "peach";
		this.cost = 3000;
	}
	
	public MessageBeanImpl(String fruit, int cost) {
		this.fruit = fruit;
		this.cost = cost;
	}
	
	@Override
	public void sayHello() {
		System.out.println(fruit + " // " + cost);
	}

}
