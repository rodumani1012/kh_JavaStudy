package com.test02;

public class Cat extends Animal {
	
	public Cat() {
		System.out.println("고양이");
	}
	
	public void bark() {
		super.bark();
		System.out.println("야옹");
	}
}
