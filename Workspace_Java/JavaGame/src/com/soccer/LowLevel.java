package com.soccer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LowLevel {

	public static void Low() {
		System.out.println("공수를 무작위로 선택합니다.");
		loading();
		adrdn();
		System.out.println("게임을 다시 하시겠습니까? y/n");
		Scanner sc = new Scanner(System.in);
		String tmp = sc.next();
		if (tmp.equals("y")) {
			System.out.println("원하시는 난이도를 선택해주세요.(① : 상 | ② : 중 | ③ : 하)");
			MTest.gamePlay();
		} else if (tmp.equals("n")) {
			System.out.println("게임을 종료합니다.");
		}
	}

	// 로딩
	private static void loading() {
		System.out.print("선택중입니다");
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(700); // sleep() : 내가 원하는 시간만큼 스레드를 멈춘다.
				// 0.7초 후
				System.out.print(".");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
		System.out.println();
	}

	// 공수 랜덤 배정
	private static void adrdn() {
		int adrdn = (int) (Math.random() * 2);
		if (adrdn == 0) {
			System.out.println("공격입니다. 공격을 시작합니다!!");
			selAtkPosition();
		} else {
			System.out.println("수비입니다. 수비를 시작합니다!!");
			selDefPosition();
		}
	}

	// 점수판
	private static void pScore(List<String> score) {
		for (String s : score) {
			System.out.print(s);
		}
		System.out.println();
	}

	// 공격일 경우
	private static void selAtkPosition() {
		List<String> score = new ArrayList<String>();

		for (int i = 0; i < 5; i++) {
			System.out.println("    공격할 위치를 선택하세요");
			System.out.println("┌─────────────────────────────┐\n│ ①왼위    ②중위    ③오위  │\n"
					+ "│ ④왼아    ⑤중아    ⑥오아  │\n└─────────────────────────────┘");
			Scanner sc = new Scanner(System.in);
			String sel = sc.next();
			switch (sel) {
			case "1":
			case "2":
			case "3":
			case "4":
			case "5":
			case "6":
				int com = (int) (Math.random() * 6) + 1;

				if (sel.equals("1")) {
					if (com != 1) {
						System.out.println(com + "골!!!!!!!!!");
						score.add("[ O ]");
					} else if (com == Integer.parseInt(sel)) {
						System.out.println(com + "막혔습니다.");
						score.add("[ X ]");
					}
				}
				if (sel.equals("2")) {
					if (com != 2) {
						System.out.println("골!!!!!!!!!");
						score.add("[ O ]");
					} else if (com == Integer.parseInt(sel)) {
						System.out.println("막혔습니다.");
						score.add("[ X ]");
					}
				}
				if (sel.equals("3")) {
					if (com != 3) {
						System.out.println("골!!!!!!!!!");
						score.add("[ O ]");
					} else if (com == Integer.parseInt(sel)) {
						System.out.println("막혔습니다.");
						score.add("[ X ]");
					}
				}
				if (sel.equals("4")) {
					if (com != 4) {
						System.out.println("골!!!!!!!!!");
						score.add("[ O ]");
					} else if (com == Integer.parseInt(sel)) {
						System.out.println("막혔습니다.");
						score.add("[ X ]");
					}
				}
				if (sel.equals("5")) {
					if (com != 5) {
						System.out.println("골!!!!!!!!!");
						score.add("[ O ]");
					} else if (com == Integer.parseInt(sel)) {
						System.out.println("막혔습니다.");
						score.add("[ X ]");
					}
				}
				if (sel.equals("6")) {
					if (com != 6) {
						System.out.println("골!!!!!!!!!");
						score.add("[ O ]");
					} else if (com == Integer.parseInt(sel)) {
						System.out.println("막혔습니다.");
						score.add("[ X ]");
					}
				}
				break;
			default:
				System.out.println("올바른 숫자를 입력해주세요.");
				i--;
				break;
			}
			pScore(score);
		}
	}

	// 수비일 경우
	private static void selDefPosition() {
		List<String> score = new ArrayList<String>();

		for (int i = 0; i < 5; i++) {
			System.out.println("    수비할 위치를 선택하세요");
			System.out.println("┌─────────────────────────────┐\n│ ①왼위    ②중위    ③오위  │\n"
					+ "│ ④왼아    ⑤중아    ⑥오아  │\n└─────────────────────────────┘");
			Scanner sc = new Scanner(System.in);
			String sel = sc.next();
			switch (sel) {
			case "1":
			case "2":
			case "3":
			case "4":
			case "5":
			case "6":
				int com = (int) (Math.random() * 6) + 1;

				if (sel.equals("1")) {
					if (com == 1) {
						System.out.println(com + "막았습니다!!!!!");
						score.add("[ O ]");
					} else if (com != Integer.parseInt(sel)) {
						System.out.println(com + "먹혔습니다ㅠㅠ");
						score.add("[ X ]");
					}
				}
				if (sel.equals("2")) {
					if (com == 2) {
						System.out.println("막았습니다!!!!!");
						score.add("[ O ]");
					} else if (com != Integer.parseInt(sel)) {
						System.out.println("먹혔습니다ㅠㅠ");
						score.add("[ X ]");
					}
				}
				if (sel.equals("3")) {
					if (com == 3) {
						System.out.println("막았습니다!!!!!");
						score.add("[ O ]");
					} else if (com != Integer.parseInt(sel)) {
						System.out.println("먹혔습니다ㅠㅠ");
						score.add("[ X ]");
					}
				}
				if (sel.equals("4")) {
					if (com == 4) {
						System.out.println("막았습니다!!!!!");
						score.add("[ O ]");
					} else if (com != Integer.parseInt(sel)) {
						System.out.println("먹혔습니다ㅠㅠ");
						score.add("[ X ]");
					}
				}
				if (sel.equals("5")) {
					if (com == 5) {
						System.out.println("막았습니다!!!!!");
						score.add("[ O ]");
					} else if (com != Integer.parseInt(sel)) {
						System.out.println("먹혔습니다ㅠㅠ");
						score.add("[ X ]");
					}
				}
				if (sel.equals("6")) {
					if (com == 6) {
						System.out.println("막았습니다!!!!!");
						score.add("[ O ]");
					} else if (com != Integer.parseInt(sel)) {
						System.out.println("먹혔습니다ㅠㅠ");
						score.add("[ X ]");
					}
				}

				break;
			default:
				System.out.println("올바른 숫자를 입력해주세요.");
				i--;
				break;
			}
			pScore(score);
		}
	}

}
