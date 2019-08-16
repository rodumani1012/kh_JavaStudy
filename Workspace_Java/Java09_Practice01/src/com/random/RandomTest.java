package com.random;

import java.util.Random;
import java.util.Scanner;
//import java.util.*;    //*하면 java.util 아래 모든 패키지 가져옴

/**
 * @author jy
 * 공식
 * (int)(Math.random()*(max - min + 1)) + min
 */
public class RandomTest {

	//java.utill.Random
	public static void randomClass() {
		Random ran = new Random();
		System.out.println(ran.nextInt(3)); //0<= n <1 사이의 숫자로 0,1,2 중 하나가 나옴
	} 
	
	// java.lang.Math
	public static void mathClass() {
		// 0.0 <= n < 1.0
		double ran = Math.random();
//		System.out.println(ran);
		
		// (int)(Math.random()*(max - min + 1)) + min
		int ran1 = (int)(Math.random()*(10-0+1)) + 0;
//		System.out.println(ran1);
		
		// 100~110 사이 랜덤값
		int ran2 = (int)(Math.random()*(110-100+1)) + 100;
		System.out.println(ran2);
	}
	
	public static void main(String[] args) {
		randomClass();
//		mathClass();
//		test01();
	}
	
	public static void test01() {
		// 숫자 a와 숫자 b를 입력받아(Scanner 사용)
		// 두 숫자 사이의 랜덤한 수 하나를 출력하자.
		Scanner s1 = new Scanner(System.in);
		
		System.out.println("첫번째 숫자 : ");
		int a = s1.nextInt();
		
		System.out.println("두번째 숫자 : ");
		int b = s1.nextInt();
		
		int random = (int)(Math.random()*(b-a+1)) + a;
		System.out.println(a + "부터 " + b + "의 난수는 " + random + "입니다.");		
	}
	
	
}
