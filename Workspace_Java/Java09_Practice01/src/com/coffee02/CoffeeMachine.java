package com.coffee02;

import java.util.Scanner;

public class CoffeeMachine {
	//돈 입력받고 일반커피or고급커피선택/ 커피잔수 선택

	public void inputMoney() {
		Scanner sc = new Scanner(System.in);
		int kind = 0;
		System.out.println("돈을 넣어주세요");
		int money = sc.nextInt();
		if (money <300) {
			System.out.println("금액이 부족합니다.....");
		} else {
			System.out.print("커피 종류를 선택하세요\t");
			System.out.println("1. 일반커피(300원) ||| 2.고급커피(500원)");
			kind = sc.nextInt();
		}
		if ((money%300 >=0) && kind==1) {
			System.out.println("몇 잔 드시겠습니까?");
			int cup = sc.nextInt();
			coffeeMake(money, kind, cup);			
		} else if ((money < 500) && kind==2) {
			System.out.println("300원으론 500원짜리 못 사먹습니다.\n잔돈을 반환합니다.");
		} else if((money%500 >=0) && kind==2) {
			System.out.println("몇 잔 드시겠습니까?");
			int cup = sc.nextInt();
			coffeeMake(money, kind, cup);						
		}
		
	}

	private void coffeeMake(int input, int sel, int cup) {
		int change = 0;
		if (sel==1) {
			change = input-300*cup;
		} else if (sel==2) {
			change = input-500*cup;
		} else {
			System.out.println("오류입니다.");
		}
		System.out.println("커피 " + cup + "잔 나왔습니다.");
		System.out.println("잔돈은 " + change + "원 입니다.");
	}
}
