package com.test03;

public class MTest {

	public static void main(String[] args) {
		
		// 1. 영어 대문자를 소문자로
		System.out.println(getLowerString("HELLO JAVA"));	
		
		// 2. 영어 소문자를 대문자로
		MTest test = new MTest();
		char upper = test.getUpperChar('y');
		System.out.println(upper);
		
	}
	
	/*
	 * 문제 1.
	 * 접근제한자는 public, 메모리영역은 static, 리턴타입은 String, 파라미터는 String 1개
	 * 메소드 명은 getLowerString
	 * 힌트 : java.lang.String
	 */
	public static String getLowerString(String a) {
		return a.toLowerCase();
	}
	
	/*
	 * 문제 2.
	 * 접근제한자는 default, 메모리영역은 non-static, 리턴타입은 char, 파라미터는 char 1개
	 * 메소드 명은 getUpperChar
	 * 힌트 : java.lang.Character
	 */
	char getUpperChar(char a) {
//		return ' ';
		
//		return Character.toUpperCase(a); //방법1. toUpperCase는 static메소드로 상위클래스인 Character을 불러야한다.
		return (char)((int)a-32); //방법2. 아스키코드 상에서 대문자와 소문자의 차이값은 32이다.
		
	}
	
}
