package com.test01;

public abstract class Animal {

	//추상 메소드 : 상속받는 자식 class에서 반드시 구현해야 한다.
	// ∴ 구현을 강제시킨다.
	public abstract void bark();  // 메소드 선언용. (오버라이드 할 필요가 없어진다.)
	
	public void eat(String feed) {
		System.out.println(feed + "먹는다.");
	}
}
