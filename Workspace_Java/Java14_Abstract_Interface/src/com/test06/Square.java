package com.test06;

import java.util.Scanner;

public class Square extends AreaImpl {

	public Square() {
		
	}
	
	@Override
	public void make() {
		Scanner sc = new Scanner(System.in);
		System.out.println("밑변을 입력해주세요 : ");
		int width = sc.nextInt();
		System.out.println("높이를 입력해주세요 : ");
		int height = sc.nextInt();		
		
		int res = width * height;

//		setResult(String.valueOf(res));
		setResult(res + ""); //간단 버전, abstract 'class' 이므로 super 사용가능.
	}
	
	public void print() {
		
		System.out.print("사각형의 ");
		super.print();
		
		
	}
}
