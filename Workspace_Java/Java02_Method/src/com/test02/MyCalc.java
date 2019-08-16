package com.test02;

public class MyCalc {
	// 사칙연산 기능을 하는 클래스
	
	// 접근제한자 메모리영역 리턴타입 메소드명(파라메터) { }
	// 더하기
	public static void sum(int i, int j) {
		//sum이라는 메소드에 무언가가 들어갔지만 void는 결과가 나오지 않는 타입을 말함.
		int res = i + j;
		System.out.println("더하기 : " + res);
	}
	
	// 빼기
	public static int sub(int i, int j) {
		//sub라는 메소드는 무언가(i와 j) 들어가서 결과를 int 타입으로 돌려준다.
		int res = i - j;
		return res;
//		return 0;
	}
	
	// 곱하기
	public static double mul(double i, double j) {
		
		double res = i * j;
		
		return res;
		
	}
	
	// 나누기
	public static void div(int i, int j) {
		// 몫
		int div01 = i / j;
		// 나머지
		int div02 = i % j;
		
		System.out.printf("나누기 : 몫(%d), 나머지(%d)", div01, div02);
	}
}
