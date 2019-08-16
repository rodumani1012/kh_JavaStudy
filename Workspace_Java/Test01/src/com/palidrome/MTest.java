package com.palidrome;

import java.util.Arrays;
import java.util.Scanner;

public class MTest {
	/*
	 * 입력한 문자가 회문인지 아닌지 판별하는 프로그램을 작성하자. 회문(Palidrome) : 앞으로 읽어도 거꾸로 읽어도 똑같은 것. ex)
	 * level, 12321 등등..
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("입력해 주세요 : ");
		
//		String input = sc.next();
//		if(isPalin(input)) {
//			System.out.println("회문이 맞습니다.");
//		} else {
//			System.out.println("회문이 아닙니다.");
//		}

//		palindrome(input);

		int input = sc.nextInt();
		plusPalindrome(input);
		
	}

	public static void plusPalindrome(int input) {

		String s = Integer.toString(input); //들어온 숫자를 문자로 바꿔서 char 배열에 넣기
		int start = 0; 
		int end = s.length();
		
//		for (int i = 0; i < array.length; i++) {
//			s.charAt(end);
//		}
		/*
		 * char[] reverse = new char[s.length]; //들어온 문자의 길이만큼 배열 생성 int[] sum = new
		 * int[s.length];
		 * 
		 * int arrIndex = 0;
		 * 
		 * //거꾸로 넣기 for(int i = s.length-1; i>=0; i--) { reverse[i] = s[arrIndex];
		 * arrIndex++; }
		 * 
		 * //기존과 거꾸로를 더하기 for(int i = 0; i<s.length; i++) { sum[i] =
		 * Integer.parseInt(s[i]+"") + Integer.parseInt(reverse[i]+""); }
		 * System.out.println(Arrays.toString(sum));
		 * 
		 * //회문 판별 char[] res = null; for (int i = 0; i < res.length; i++) { res[i] =
		 * Integer.toString(sum[i]);
		 * 
		 * }
		 */
		
		//에러나서 잠깐 주석처리
//		System.out.println(Arrays.toString(res));
//		boolean b = true;
//		for (int i = 0; i < res.length; i++) {
//			if(res[i] == res[res.length-1-i]) {
//				continue;
//			} else {
//				b = false;
//				break;
//			}
//		}
//
//		if(b) {
//			System.out.println("회문입니다");
//		} else {
//			System.out.println("회문이 아닙니다.");
//		}
		

	}

	public static void palindrome(String input) {
		// 1. 입력된 String을 char[]로 변환하시오.
		char[] c = input.toCharArray();
		// 2. char[]의 값을 거꾸로 하여 reverse라는 배열에 저장하시오.
		char[] reverse = new char[c.length];
		for (int i = c.length - 1; i >= 0; i--) {

			reverse[c.length - 1 - i] = c[i];// length4 i=3

		}
		// 3. 입력된 char[]의 값과
		// reverse 배열의 값을 비교하자.
		boolean b = true;
		for (int i = 0; i < c.length; i++) {
			if (c[i] == reverse[i]) {
				continue;
			} else {
				b = false;
				break;
			}
		}
		// 4. 배열 전체가 같으면 출력하자.
		if (b == true) {
			System.out.println("회문입니다.");
		} else {
			System.out.println("회문이 아닙니다.");
		}
	}

	public static boolean isPalin(String input) {
		StringBuffer sb = new StringBuffer(input);

		String reverse = sb.reverse().toString();

		if (input.equals(reverse)) {
			return true;
		}

		return false;
	}
}
