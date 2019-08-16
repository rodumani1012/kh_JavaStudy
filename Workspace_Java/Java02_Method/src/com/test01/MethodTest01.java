package com.test01;

public class MethodTest01 {

	/*
	 * 접근제한자 메모리영역 리턴타입 메소드명(파라메터){
	 * 
	 * }
	 */
	
	// 프로그램의 주 진입점으로써 메인안의 명령만 실행됨.
	public static void main(String[] args) {
		MethodTest01.publicMethod();
		MethodTest01.protectedMethod();
		defaultMethod();
		privateMethod();
//		~~. 을 안써도 되는 이유
		// nonStaticMethod();
		// 메모리의 영역이 달라서 에러 발생.
	}
	
	// 어디서든 접근, 참조 가능
	public static void publicMethod() {
		System.out.println("public method");
	}
	
	/*
	 * 상속일 경우, 상속된 곳 어디서나 
	 * 상속이 아닐경우, 패키지 내에서만 접근, 참조 가능
	 */
	protected static void protectedMethod() {
		System.out.println("protected method");
	}
	
	// 접근제한자를 생략한 디폴트 메소드로써 같은 패키지 내에서만 접근, 참조 가능(default는 생략가능)
	static void defaultMethod() {
		System.out.println("default method");
	}
	
	// 같은 클래스 내에서만 접근, 참조 가능(private는 사용하지 않으면 더미)
	private static void privateMethod() {
		System.out.println("private method");
	}
	
	
	public void nonStaticMethod() {
		System.out.println("non-static method");
	}
	
	
}

