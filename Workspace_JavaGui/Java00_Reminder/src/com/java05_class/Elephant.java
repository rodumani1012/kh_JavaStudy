package com.java05_class;

public class Elephant extends Animal{

	public Elephant(String name, int age) {
		super(name, age); // 2개짜리 부모 생성자 호출
		super.setKind("코끼리"); // 부모 객체에 값 설정
	}
	
	@Override
	public void bark() {
		System.out.print("코끼리의 ");
		super.bark();
		System.out.println("끼리끼리코끼맄");
	}
	
	
}
