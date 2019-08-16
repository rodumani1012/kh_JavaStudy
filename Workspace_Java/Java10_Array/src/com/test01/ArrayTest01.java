package com.test01;

import java.util.Arrays;

public class ArrayTest01 {
	
	// 배열(Array)
	public static void main(String[] args) {
		
		//방식 1.
		int[] a;		//선언.  int형 값을 넣을 수 있는 변수 a 선언
		a = new int[5]; //정의.  a는 5칸짜리 객체이다. □□□□□
		a[0] = 1; 		//초기화.
		a[1] = 2;
		a[2] = 3;
		a[3] = 4;
		a[4] = 5;
		
		//방식 2.  선언, 정의, 초기화
		int[] b = new int[] {5,4,3,2,1};
		
		//방식 3. 선언 초기화
		int[] c = {6,7,8,9,10};
		int d[] = {6,7,8,9,10};
		
		System.out.println("주소값 : " + a);
		System.out.println("실제값 : " + a[0]);
		
		System.out.println(a[1] + b[3]); // 2 + 2
		
		System.out.println(Arrays.toString(a));
		
		prn(a);
		System.out.println();
		
		String[] s = new String[] {"have", "a", "nice", "day"};
		// have a good day 로 출력하시오.
		s[2] = "good";
		modi(s);
		
		prn01(a);
	}
	
	// 31번 라인을 , 없이 출력하기
	public static void prn(int[] arr) {
		
		
		for(int i = 0; i <arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public static void modi(String[] arr) {
		for(int i =0; i< arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	// 1 2 3 4 5 를
	// {1, 2, 3, 4, 5} 로 표현하기
	public static void prn01(int[] arr) {
		
		System.out.println("{");
		for(int i = 0; i <arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println("}");
	}
	
	
}
