package com.test01;

public class ForTest01 {

	public static void main(String[] args) {
		prn01();
		prn02();
		prn03();
	}
	
	public static void prn01() {
		
		int i = 0;
		
		for (i=0; i<10; i++) {
			System.out.println(i);
		}
		
		System.out.println("for문이 종료된 후 i값 : " + i);
		
	}
	
	public static void prn02() {
		
		for(int i = 0; i<10; i++) {
			System.out.println(i);
		}
//		System.out.println("i : " + i); //i는 for문 안에서 선언 된 지역변수이다. 그래서 밖에서 쓰면 오류난다.
	}
	
	public static void prn03() {
		// 100부터 1까지 거꾸로 출력하자
		for(int i = 100; i>0; i--) {
			System.out.println(i);
		}
	}
}
