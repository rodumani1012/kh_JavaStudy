package com.test01;

import java.util.Scanner;

public class Next_NextLine {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("a 입력 : ");
		String a = sc.next();
		System.out.println("b 입력 : ");
		String b = sc.nextLine();
		
		System.out.println("a : " + a);
		System.out.println("b : " + b);
	}
}
