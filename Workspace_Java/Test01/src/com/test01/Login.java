package com.test01;

import java.util.Scanner;

public class Login {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String id = "kh";
		String pw = "qwer1234";
		int cnt = 0;

		while (true) {
			System.out.println("ID : ");
			String inputId = sc.next();
			System.out.println("PW : ");
			String inputPw = sc.next();

			if (id.equals(inputId) && pw.equals(inputPw)) {
				System.out.println("로그인 성공");
				break;
			} else {
				System.out.println("");
				cnt++;
				System.out.println(cnt + "번 틀렸습니다.");
				if (cnt == 3) {
					System.out.println("프로그램이 종료됩니다.");
					break;
				}
			}
		}
	}
}
