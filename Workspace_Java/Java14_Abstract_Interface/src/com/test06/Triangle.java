package com.test06;

import java.util.Scanner;

public class Triangle extends AreaImpl {

	public Triangle () {
		
	}
	
	@Override
	public void make() {
		Scanner sc = new Scanner(System.in);
		System.out.println("밑변을 입력해주세요 : ");
		int width = sc.nextInt();
		System.out.println("높이를 입력해주세요 : ");
		int height = sc.nextInt();		
		
		double res = width * height/2.0;
		
//		setResult(String.valueOf(res));
		super.setResult(res + ""); //간단 버전, abstract 'class' 이므로 super 사용가능.

	}
	
	public void print() {
		// 삼각형의 넓이 : + result
		System.out.print("삼각형의 ");
		super.print();
		
	}

}
