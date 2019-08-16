package com.coffee;

import java.util.Scanner;

public class CoffeeMachine {
	
	public void inputMoney() {
		System.out.println("돈을 넣어 주세요");
		System.out.println("(1잔당 300원)");
		
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();
		
		if(money >= 300) {
			coffeeMake(money);
		} else {
			System.out.println("금액이 부족합니다...");
		}
	}
	
	private void coffeeMake(int input) {
		int coffee = input/300; //커피잔의 갯수
		int change = input%300; //잔돈
		
		System.out.println("커피 " + coffee + "잔 나왔습니다.");
		System.out.println("잔돈은 " + change + "원 입니다.");
		
	}
}
