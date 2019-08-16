package com.test01;

import java.util.Scanner;

public class ScannerTest02 {

	public static void main(String[] args) {
		// 1. 숫자를 입력 받아서 해당 숫자를 리턴하는
		// 메소드를 만들자.
		
		// 2. 정수형 변수 a와 정수형 변수 b에다가
		// 1번에서 만든 메소드를 호출하여 값을 대입하자.
		int a = inputNum();
		int b = inputNum();
		// 3. 파라미터 2개를 받아서 해당 값들을 더하고
		// 더한 값을 리턴하는 메소드를 만들자.
		
		// 4. 3번에서 만든 메소드에 2번에서 값을 대입한
		// a와 b를 아규먼트로 넣어서 리턴받은 값을 출력하자.
		// "입력받은 숫자는 ㅁ 와 ㅁ이고, 두 숫자의 합은 ㅁ 입니다." 
		int res = sum(a, b);
		System.out.printf("입력받은 값은 %d와 %d 이고, 두 숫자의 합은 %d 입니다.", a,b,res);
	}
	//1번
	public static int inputNum() {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요 : ");
		int i = sc.nextInt();
		return i;		
	}
	//3번
	public static int sum(int z, int x) {
//		int res = z + x;
//		return res;
		return z + x;
	}
}
