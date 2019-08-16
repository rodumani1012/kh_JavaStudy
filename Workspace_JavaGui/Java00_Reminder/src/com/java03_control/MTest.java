package com.java03_control;

import java.util.Scanner;

public class MTest {
	 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("i 입력 : ");
		int i = sc.nextInt();
		System.out.println("j 입력 : ");
		int j = sc.nextInt();
		
		// i의 j제곱을 리턴
//		System.out.println(forTest(i,j));
//		System.out.println(whileTest(i,j));
		
		// i의 j제곱을 하는데
		// 만일 j=0 이면 "0을 제곱하면 1입니다."
		// j=1이면 "1을 제곱하면 자기 자신입니다."
		// 아니면 i의 j제곱을 출력
		switchTest(i,j);
		
		// 큰수의 작은수 제곱을 리턴
		//System.out.println(ifTest(i,j));
	}
	
	public static int forTest(int i, int j) {
		int res = 1;
		for(int a = 0; a<j; a++) {
			res *= i;
		}		
		return res;
	}
	
	public static int whileTest(int i, int j) {
		int res = 1;
		int cnt = 0;
		while(cnt < j) {
			res *= i;
			cnt++;
		}		
		return res;
	}
	
	public static void switchTest(int i, int j) {		
		switch (j) {
		case 0:
			System.out.println("0을 제곱하면 1입니다.");
			break;
		case 1:
			System.out.println("1을 제곱하면 자기 자신입니다.");
			break;
		default :
			System.out.println((int)Math.pow(i, j));
			break;
		}
		
	}
	
	public static int ifTest(int i, int j) {
		int res = 0;
		if(i > j) {
			res = (int)Math.pow(i, j);
		} else {
			res = (int)Math.pow(j, i);
		}
		return res;
	}
}
