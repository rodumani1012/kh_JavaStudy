package com.test01;

public class WhileTest01 {

	public static void prn03() {

		int i = 1;

		while (true) {
			System.out.println(i);
			i++;

			if (i == 10) {
				break;
			}
		}
	}

	public static void main(String[] args) {
		prn01();
		System.out.println("============");
		prn02();
		prn03(); // if문을 없애면 무한루프 된다.

	}

// while은 조건이 참일때 명령을 실행,
	// do while은 do안의 명령을 먼저 실행한 후 while안의 조건을 확인
	public static void prn01() {
		// 초기값
		int i = 10;

		// 조건식
		while (i < 10) {
			// 명령
			System.out.println(i);
			// 증감식
			i++;
		}

		System.out.println("whlie이 종료된 후의 i 값 : " + i);
	}

	public static void prn02() {
		int i = 10;

		do {
			System.out.println(i);
			i++;
		} while (i < 10);
		System.out.println("do while 이 종료된 후의 i 값 : " + i);
	}

}
