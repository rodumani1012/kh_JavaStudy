package com.test02;

public class MyException extends Exception {

	public MyException() {
		this("Exception Test"); // this(); 파라미터 하나 받는 내 생성자 호출.
								// super(); 부모 생성자 호출.
	}
	
	public MyException(String message) {
		super(message); //Exception 클래스 코드를 타고 들어가보면 결국엔 출력해주는 메소드가 있다.
	}
}
