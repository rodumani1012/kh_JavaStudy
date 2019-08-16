package com.test06;

import java.util.Scanner;

public class Circle extends AreaImpl {
	
	public Circle() {
		
	}

	@Override
	public void make() {
		Scanner sc = new Scanner(System.in);
		System.out.println("반지름을 입력해주세요 : ");
		double half = sc.nextDouble();
		double res = Math.PI * Math.pow(half, 2);
		
//		setResult(String.valueOf(res));
		setResult(res + ""); //간단 버전, abstract 'class' 이므로 super 사용가능.
		
	}
	
	
	public void print() {	
		System.out.print("원의 ");		
		super.print();
		
	}
	
}
