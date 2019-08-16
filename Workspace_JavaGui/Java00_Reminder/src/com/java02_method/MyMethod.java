package com.java02_method;

public class MyMethod {

	public static void myPublic() {
		System.out.println("public : 어디서나");
	}
	
	protected static void myProtected() {
		System.out.println("protected : 상속된 곳 어디서나");
		System.out.println("protected : 상속이 아닌 경우 같은 패키지");
	}
	
	static void myDefault() {
		System.out.println("(default) : 같은 패키지");
	}
	
	private static void myPrivate() {
		System.out.println("private : 같은 클래스");
//		myNonStatic(); // 스테틱에서 논스테틱 호출 불가. 객체 생성해야 호출 가능
//		MyMethod m1 = new MyMethod();
//		m1.myNonStatic();
	}
	
	public void myNonStatic() {
		System.out.println("객체를 생성해야 호출 가능");
		myPrivate(); // 논 스테틱에서 스테틱 호출 가능
	}
}
