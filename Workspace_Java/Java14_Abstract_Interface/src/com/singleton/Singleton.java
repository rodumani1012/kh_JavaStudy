package com.singleton;

// Singleton : 메모리(heap)에 객체를 한번만 생성한다.
public class Singleton {

	// singleton 객체 생성 방법
	// 1. 생성자를 private로 만든다. (외부에서 생성자를 통해 객체생성 할 수 없도록)
		//private이기 때문에 new 사용 불가능.
	private Singleton() {
		System.out.println("singleton instance 생성!");
	}
	
	// 2. 객체를 확인할 주소(reference) 객체명을 선언
	private static Singleton singleton;
	
	// 3. 내 객체가 heap 영역에 있는지 확인.
	// 만일 없으면 생성, 있으면 이미 만들어진 객체의
	// 주소를 리턴
	public static Singleton getInstance() {
		if(singleton == null) {
			System.out.println("new!!");
			singleton = new Singleton(); //singleton에 주소값을 넣어줌.
		} else {
			System.out.println("exist!!");
		}
		
		return singleton;
	}
}
