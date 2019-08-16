package com.switch01;

public class SwitchTest02 {

	public static void main(String[] args) {
		String s = "한국";
		
		// java 7버전 부터 문자열 가능
		switch (s) {
		case "한국":
			System.out.println("korea");
			break;
		case "중국":
			System.out.println("china");
			break;
		case "일본":
			System.out.println("japan");
			break;

		default:
			System.out.println("다른 나라");
			break;
		}

	}

}
