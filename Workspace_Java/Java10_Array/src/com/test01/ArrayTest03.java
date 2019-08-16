package com.test01;

public class ArrayTest03 {

	// 1. 일차원 배열을 만들어서
	/*
	 * a b c d e
	 * f g h i j
	 * k l m n o
	 * p q r s t 
	 * u v w x y
	 * z
	 * 
	 * 형태로 출력하자
	 */
	
	// 2. 1번 문제를 거꾸로 z y x.... 출력하자
	
	// 3. 1번 문제를 대문자로 바꿔서 출력 A B C D E...
	
	public static void main(String[] args) {
		String[] s = {"a","b","c","d","e","f","g","h","i","j","k","l","m",
				"n","o","p","q","r","s","t","u","v","w","x","y","z"};
//		prn01(s);
//		System.out.println();
//		prn02(s);
//		System.out.println();
//		prn03(s);
		
		//강사님
		char[] arr = test01();
		for(int i = 0; i<arr.length; i++) {
			if(i%5==0 && i != 0) {
				System.out.println();
			}
			System.out.print(arr[i] + " ");
		}
		
		System.out.println();
		test02(arr);
		System.out.println();
		test03(arr);
	}
	
	public static void prn01(String[] arr) {
		for(int i = 1; i<arr.length+1; i++) {
			System.out.print(arr[i-1] + " ");
			if (i%5==0) {
				System.out.println();
			}
		}
	}
	
	public static void prn02(String[] arr) {
		for(int i = 25; i>-1; i--) {
			if (i%5==0 && i != 25) {
				System.out.println();
			}
			System.out.print(arr[i] + " ");
		}
	}

	public static void prn03(String[] arr) {
		for(int i = 1; i<arr.length+1; i++) {
			System.out.print((arr[i-1]).toUpperCase() + " ");
			if (i%5==0) {
				System.out.println();
			}
		}
	}
	
	//강사님
	public static char[] test01() {
		char[] ch = new char[26];
		for(int i = 0; i <ch.length; i++) {
			ch[i] = (char)((int)'a'+i); //a를 숫자로
				//바꿔서 i값을 더한 후 문자로 바꾸는 과정
		}
		return ch;
	}
	
	//강사님
	public static void test02(char[] ch) {
		int temp = 1;
		for (int i = ch.length; i>0; i--) {
			System.out.print(ch[i-1] + " ");
			if(temp%5==0) {
				System.out.println();
			}
			temp++;
		}
	}

	//강사님
	public static void test03(char[] arr) {
		
		for (int i = 1; i<arr.length; i++) {
			System.out.print(Character.toUpperCase(arr[i-1]) + " ");
			if(i%5==0) {
				System.out.println();
			}
		}
	}	
}


