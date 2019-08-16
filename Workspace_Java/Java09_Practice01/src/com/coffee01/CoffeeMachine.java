package com.coffee01;

import java.util.Scanner;

public class CoffeeMachine {
	//돈 넣고 커피 몇 잔 선택 후 잔돈 반환

	public void inputMoney() {
		System.out.println("돈을 넣어주세요");
		System.out.println("(1잔당 300원)");

		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();
		if(money<300) {
			System.out.println("금액이 부족합니다.....");
		} else { System.out.println("몇 잔 드시겠습니까?");
		int cup = sc.nextInt();
		coffeeMake(money, cup);
		}
	}

	private void coffeeMake(int input, int cup) {
		int change = input-300*cup;
		if(change >= 0) {
			System.out.println("커피 " + cup + "잔 나왔습니다.");
			System.out.println("잔돈은 " + change + "원 입니다.");
		} else {
			System.out.println("금액이 부족합니다.....");
			System.out.println("잔돈은 " + input + "원 입니다.");
		}


	}
}
