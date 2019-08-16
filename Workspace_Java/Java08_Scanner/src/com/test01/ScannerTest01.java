package com.test01;

import java.util.Scanner;

public class ScannerTest01 {

	public static void test01() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("첫번째 숫자 입력 : ");
		int a = sc.nextInt();
		
		System.out.println("두번째 숫자 입력 : ");
		int b = sc.nextInt();
		
		int sum = a+b;
		System.out.println("두 수의 합 : " + sum);
	}
	
	public static void test02() {
		Scanner sc = new Scanner(System.in);
		System.out.println("이름을 입력해 주세요 : ");
		String name = sc.next();
		System.out.println("안녕하세요, " + name + "씨");
	}
	
	public static void main(String[] args) {
//		test01();
		test02();
	}
}
