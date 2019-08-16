package com.soccer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Play {

	Scanner sc = new Scanner(System.in);
	String select = "";
	
	public void game() {
		System.out.println("\t\t\t☆★☆★☆★☆★☆★☆★☆★☆\n\t\t\t|승부차기 게임|\n\t\t\t☆★☆★☆★☆★☆★☆★☆★☆\n");

		select = selLevel(); // 상중하 고르기
		loading(); // 랜덤 선택 전 로딩 모션
		adrdn(); // 공수 랜덤 배정 -> 공격 or 수비로 이동
		System.out.println("게임을 다시 하시겠습니까? y/n");
		Scanner sc = new Scanner(System.in);
		String tmp = sc.next();
		if (tmp.equals("y")) {
			game();
		} else if (tmp.equals("n")) {
			System.out.println("게임을 종료합니다.");
		}
	}
	
	private void pScore(List<String> score) {
		for (String s : score) {
			System.out.print(s);
		}
		System.out.println();
	}

	public String selLevel() {
		while (true) {
			System.out.println("원하시는 난이도를 선택해주세요.(① : 상 | ② : 중 | ③ : 하)");
			String level = sc.next();
			switch (level) {
			case "1":
				System.out.println("난이도 상을 선택 하셨습니다"); // 상 33%
				return level;
			case "2":
				System.out.println("난이도 중을 선택 하셨습니다"); // 중 50%
				return level;
			case "3":
				System.out.println("난이도 하를 선택 하셨습니다"); // 하 84%
				return level;
			default:
				System.err.println("1~3 사이의 숫자만 입력해주세요.");
				break;
			}
		}
	}

	public int[] level(String select) {

		int[] res = null;

		switch (select) {
		case "1":
			res = new int[4];
			for (int i = 0; i < res.length; i++) {
				res[i] = (int) (Math.random() * 6) + 1;
				for (int j = 0; j < i; j++) {
					if (res[i] == res[j]) {
						i--;
						break;
					}
				}
			}
			break;
		case "2":
			res = new int[3];
			for (int i = 0; i < res.length; i++) {
				res[i] = (int) (Math.random() * 6) + 1;
				for (int j = 0; j < i; j++) {
					if (res[i] == res[j]) {
						i--;
						break;
					}
				}
			}
			break;
		case "3":
			res = new int[2];
			for (int i = 0; i < res.length; i++) {
				res[i] = (int) (Math.random() * 6) + 1;
				for (int j = 0; j < i; j++) {
					if (res[i] == res[j]) {
						i--;
						break;
					}
				}
			}
		}
		return res;
	}

	public String input() {
		System.out.println("    공수 위치를 선택하세요");
		System.out.println("┌─────────────────────────────┐\n│ ①왼위    ②중위    ③오위  │\n"
				+ "│ ④왼아    ⑤중아    ⑥오아  │\n└─────────────────────────────┘");
		String input = sc.next();

		return input;
	}

	// 로딩
	private void loading() {
		System.out.print("공격 및 수비가 랜덤으로 선정됩니다.");
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(600); // sleep() : 내가 원하는 시간만큼 스레드를 멈춘다.
				// 0.7초 후
				System.out.print(".");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
		System.out.println();
	}

	// 슛~~
	private void shoot() {
		System.out.print("슛");
		for (int i = 0; i < 15; i++) {
			try {
				Thread.sleep(100); // sleep() : 내가 원하는 시간만큼 스레드를 멈춘다.
				// 0.7초 후
				System.out.print("~ ");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
		System.out.println();
	}

	// 공수 랜덤 배정
	private void adrdn() {
		int adrdn = (int) (Math.random() * 2);
		if (adrdn == 0) {
			System.out.println("공격입니다. 공격을 시작합니다!!");
			selAtkPosition();
		} else {
			System.out.println("수비입니다. 수비를 시작합니다!!");
			selDefPosition();
		}
	}

	private void selAtkPosition() {
		List<String> score = new ArrayList<String>();

		for (int i = 0; i < 5; i++) {
			int[] computer = level(select); // 상중하에 따른 컴퓨터 배열 결정
			Arrays.sort(computer);
			String user = input(); // 1,2,3,4,5,6 위치 고르기
			switch (user) {
			case "1":
			case "2":
			case "3":
			case "4":
			case "5":
			case "6":
				break;
			default:
				System.err.println("올바른 숫자를 입력해주세요.");
				i--;
				continue;
			}
			shoot();
			int count = 0; // while문 초기화 변수
			int goal = 0; // 골
			int noGoal = 0; // 노골

			while (count < computer.length) {
				if (Integer.parseInt(user) == computer[count]) {
					noGoal++;
				} else {
					goal++;
				}
				count += 1;
			}

			if (noGoal > 0) {
				System.out.println("막혔습니다!");
				score.add("[ X ]");
			} else if (goal > 0 || noGoal == 0) {
				System.out.println("골!!!!!!!!");
				score.add("[ O ]");
			}
			System.out.println("사용자의 위치는 : " + user + " 이였으며 " + "컴퓨터의 위치는 " + Arrays.toString(computer) + "였습니다!"); // 컴퓨터 난수 봐보기
			pScore(score);
		}
	}

	private void selDefPosition() {
		List<String> score = new ArrayList<String>();

		for (int i = 0; i < 5; i++) {
			int[] computer = level(select); // 상중하에 따른 컴퓨터 배열 결정
			Arrays.sort(computer);
			String user = input(); // 1,2,3,4,5,6 위치 고르기
			switch (user) {
			case "1":
			case "2":
			case "3":
			case "4":
			case "5":
			case "6":
				break;
			default:
				System.err.println("올바른 숫자를 입력해주세요.");
				i--;
				continue;
			}
			shoot();
			int count = 0; // while문 초기화 변수
			int goal = 0; // 골
			int noGoal = 0; // 노골

			while (count < computer.length) {
				if (Integer.parseInt(user) == computer[count]) {
					noGoal++;
				} else {
					goal++;
				}
				count += 1;
			}

			if (noGoal > 0) {
				System.out.println("막았습니다!");
				score.add("[ X ]");
			} else if (goal > 0 || noGoal == 0) {
				System.out.println("먹혔습니다 ㅠㅠㅠㅠㅠ");
				score.add("[ O ]");
			}
			System.out.println("사용자의 위치는 : " + user + " 이였으며" + "컴퓨터의 위치는 " + Arrays.toString(computer) + "였습니다!"); // 컴퓨터
																													// 난수
																													// 봐보기
			pScore(score);
		}
	}
}
