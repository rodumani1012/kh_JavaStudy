package com.if01;

public class IfTest02 {
	
	public static void main(String[] args) {
		// 1. 전달된 값이 5의 배수라면
		// "5의 배수입니다." 를 출력하자.
		// int		
		test01(5);
		
		// 2. 전달된 값이 2의 배수 이면서3의 배수라면
		// "2와 3의 배수 입니다." 를 출력하자
		// int
		test02(6);
		
		// 3. 전달된 값이 소문자라면 "소문자 입니다."
		// 대문자라면 "대문자 입니다." 를 출력하자
		// char
		test03('A');
	}
	
	private static void test01(int i) {
		if (i%5 == 0) {
			System.out.println("5의 배수입니다.");
		} else {
			System.out.println("5의 배수가 아닙니다.");
		}
	}

	private static void test02(int i) {
		if ((i%2 == 0) && (i%3 == 0)) {
			System.out.println("2와 3의 배수 입니다.");
		} else {
			System.out.println("2와 3의 배수가 아닙니다.");
		}
		
	}

	private static void test03(char a) {
		if (Character.isUpperCase(a)) {
			System.out.println("대문자 입니다.");
		} else if (Character.isLowerCase(a)) {
			System.out.println("소문자 입니다.");
		} else {
			System.out.println("잘못입력하셨습니다.");
		}
		
	}


}
