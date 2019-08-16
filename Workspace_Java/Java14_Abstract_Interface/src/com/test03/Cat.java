package com.test03;

public class Cat implements Animal {
				// interface를 상속받을땐 implements
	@Override
	public void bark() {
		System.out.println("야옹");

	}

	@Override
	public void eat(String feed) {
		System.out.println(feed + " 먹는다.");

	}

}
