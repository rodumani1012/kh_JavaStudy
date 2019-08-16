package com.baseball;

public class Print {

	static String START = "게임을 시작합니다.";
	static String ING = " 번째 도전";
	
	static String WIN = "맞추셨습니다!!";
	static String LOSE_PRE = "목표했던 숫자는 ";
	static String LOSE_POST = " 입니다.";
	
	static String ERROR = "예상하지 못한 상황으로 게임이 종료됩니다.";
	
	static String END = "게임이 끝났습니다.\n 다시 시작할까요?(y/n)";
	static String BYE = "수고하셨습니다.";
	
	static void strikePrn(int[] input) {
		if(input[2] == 1) {
			System.out.println("out입니다.");
		}else {
			System.out.printf("%d strike %d ball 입니다.\n",input[0],input[1]);
		}
	}
}
