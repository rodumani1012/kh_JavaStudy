package com.test01;

public class WhileTest02 {

	public static void main(String[] args) {
		// static method를 만들어 문제를 풀자.
		// 1. 1~100까지의 숫자를 역순으로 출력하자.
		test01();
		System.out.println("========================");
		
		// 2. 1~100까지의 숫자 중, 2의 배수만 출력하자.
		test02();
		System.out.println("========================");
		
		// 3. 1~100까지의 숫자 중, 7의 배수의 갯수와 총합을 출력하자.
		test03();
		System.out.println("========================");
	}
	
	public static void test01() {
		// 초기값
		int i = 100;
		// 조건식
		while (i>0) {
			System.out.println(i);
			// 증감식
			i--;
		}
	}
	
	public static void test02() {
		int i = 1;
		while (i <= 100 ) {
			if(i%2 == 0) {
				System.out.println(i);
			}
			i++;
		}
	}
	
	public static void test03() {
		int i = 1;
		int count = 0;
		int sum = 0;
		while (i <= 100) {
			if(i%7 ==0) {
				System.out.println(i);
				sum += i;
				count++;				
			}
			i++;
		}
		System.out.println("7의 배수 총합은 " + sum + "입니다.");
		System.out.println("7의 배수의 갯수는 " + count + "개 입니다.");
	}

}
