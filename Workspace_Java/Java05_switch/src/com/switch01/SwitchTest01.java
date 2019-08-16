package com.switch01;

public class SwitchTest01 {

	public static void main(String[] args) {
		prn01();
		prn02();
	}
	
	public static void prn01() {
		int i = 3;
		
		// if는 순차적으로 모든 코드를 읽지만 switch는 해당 case로 jumping한다.
		// switch(값(정수형,문자형,문자열) 또는 식)
		// case(값)
		// break : 자신을 감싸고 있는 중괄호 밖으로 나감
		// default : 그 외에 값들일 경우
		switch(i) {
		case 1: 
			System.out.println("1입니다.");
			break;
		case 2:
			System.out.println("2입니다.");
			break;
		case 3:
			System.out.println("3입니다.");
			break;
		}
	}

	public static void prn02() {
		int i = 5;
		
		switch(i) {
		case 1:
		case 3:
			System.out.println("홀수입니다.");
			break;
		case 2:
		case 4:
			System.out.println("짝수입니다.");
			break;
		default :
			System.out.println("다른 숫자 입니다.");
			break;
		}
	}
}
