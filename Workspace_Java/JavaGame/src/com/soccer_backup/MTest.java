package com.soccer_backup;

import java.util.Scanner;

public class MTest {

	public static void main(String[] args) {

		System.out.println("\t☆★☆★☆★☆★☆★☆★☆★☆\n\t|승부차기 게임|\n\t☆★☆★☆★☆★☆★☆★☆★☆\n");
		System.out.println("원하시는 난이도를 선택해주세요.(① : 상 | ② : 중 | ③ : 하)");

		gamePlay();
		
	}
	
	public static void gamePlay() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			String level = sc.next();
			switch (level) {
			case "1":
				System.out.println("난이도 상입니다"); //상 33%
				HighLevel.High();
				break;
			case "2":
				System.out.println("난이도 중입니다"); //중 50%
				MidLevel.Mid();
				break;
			case "3":
				System.out.println("난이도 하입니다"); //하 84%
				LowLevel.Low();
				break;
			default:
				System.out.println("1~3 사이의 숫자만 입력해주세요.");
				break;
			}
		}
	}
}
