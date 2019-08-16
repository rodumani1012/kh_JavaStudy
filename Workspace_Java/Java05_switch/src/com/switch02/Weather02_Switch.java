package com.switch02;

// switch를 사용해서 봄/여름/가을/겨울
public class Weather02_Switch {
	
	public static void main(String[] args) {
		weather(11);
	}
	
	public static String weather(int a) {
		switch (a) {
		case 3:
		case 4:
		case 5:
			return "봄";
			
		case 6:
		case 7:
		case 8:
			return "여름";
			
		case 9:
		case 10:
		case 11:
			return "가을";

		case 12:
		case 1:
		case 2:
			return "겨울";
		
		default:	
			return "잘못 입력하셨습니다.";
		}
	}
}
