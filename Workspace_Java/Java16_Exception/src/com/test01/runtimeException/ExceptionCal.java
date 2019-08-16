package com.test01.runtimeException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionCal {

	public int calculation() {
		int res = 0;

		while (true) {

			try {
				res = inputNum() / inputNum(); // 에러가 날거 같은 곳을 묶어둠
				System.out.println(res);

				break;

			} catch (InputMismatchException e) { // InputMismatchException 에러 발생시
//				System.out.println(e);	//처리할 명령
				e.printStackTrace(); // 스택에 쌓인 것을 출력해주는 메소드.

			} catch (Exception e) { // 그외 Exception 에러 발생시 (Exception은 모든 예외의 조상)
									// 정확한 에러를 집어주지 않고 Exception만 쓰면 실행속도가 느려질 수 있음.
				System.out.println(e); // 처리할 명령
			}
		}

		return res; // break가 없으면 while이 true여서 계속 돌기때문에 에러
	}

	public int inputNum() {
		int i = 0;

		System.out.println("숫자만 입력해 주세요 : ");
		Scanner sc = new Scanner(System.in);

		i = sc.nextInt();

		return i;
	}
}
