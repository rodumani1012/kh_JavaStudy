package com.test02;

import java.util.Scanner;

public class MTest {

	public static void main(String[] args) {
		System.out.println("동물을 선택해 주세요.");
		System.out.println("1:고양이 2:멍멍이 3:코끼리");
		
		Scanner sc = new Scanner(System.in);
		int select = sc.nextInt();
		
//		Base base = new Base(); // 오류 발생. 추상클래스인 base 는 객체화 할 수 없다.
		Base base = null;
		
		switch (select) {
		case 1:
			base = new Cat();
			break;
		case 2:
			base = new Dog();
			break;
		case 3:
			base = new Elephant();
			break;
		default:
			break;
		}
		
		base.start();
		base.stop();
		
		/*
		 * Cat cat = new Cat, Dog dog = new Dog, Elep~ elep~ = new Elep~ 라고 선언하지 않아 코드를 낭비하지 않으며
		 * switch 문을 통해 객체가 이후에 생성되기 때문에 코드절약, 속도향상, 행위은닉이 일어나는 동적 바인딩.
		 * 
		 * 만들어진 것을 가져다 쓰는 것이 정적.
		 * 언제 쓰일지 모르는 것이 동적. 
		 * 
		 * 동적 바인딩
		 * - 실행시 메모리 할당을 하면서 
		 * 	 메소드를 동적으로 연동하는 방식.
		 * 
		 * 1. 코드 절약
		 * 2. 실행속도 향상
		 * 3. 행위 은닉
		 * 
		 * 
		 */
		
		
	}

}
