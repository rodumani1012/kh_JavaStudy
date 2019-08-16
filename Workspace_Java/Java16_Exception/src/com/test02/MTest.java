package com.test02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MTest {

	public static void main(String[] args) {
		int a = 0;

		try {
			System.out.println("숫자만 입력해 주세요 :");
			Scanner sc = new Scanner(System.in);

			a = sc.nextInt();

			if (a == 4) {
				throw new MyException(); //throw : 예외를 발생시켜 객체(Exception을 상속받는)에게 전달하는 역할
			}
		} catch (MyException e) {
			System.out.println(e);
			System.err.println("내가 만든 예외");  // err로 하면 빨간 글씨로 나옴

		} catch (InputMismatchException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
