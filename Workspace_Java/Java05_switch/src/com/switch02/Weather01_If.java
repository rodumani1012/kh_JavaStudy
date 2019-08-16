package com.switch02;

// if를 사용해서 봄/여름/가을/겨울
public class Weather01_If {
	
	public static void main(String[] args) {
		weather(1);
	}
	
	public static void weather(int a) {
		if ((a>=3) && (a<6)) {
			System.out.println("봄");
		} else if ((a>=6) && (a<9)) {
			System.out.println("여름");
		} else if ((a>=9) && (a<12)) {
			System.out.println("가을");
		} else if ((a==12) || (a<3)) {
			System.out.println("겨울");
		} else {
			System.out.println("잘못 입력하셨습니다.");
		}
	}
}
