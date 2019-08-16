package com.gugudan;

public class Gugudan {

	public static void main(String[] args) {
		// 1. prn01() : while()
		prn01();
		// 2. prn02() : for()
		prn02();
	}
	
	public static void prn01() {
		int a = 2;
		int b = 1;
		int mul = 0;
		while(a<=9) {

			System.out.println("<<< " + a + "단 >>>");
			while(b<=9) {
				mul = a*b;
				System.out.println(a + " * " + b + " = " + mul);
				b++;
			}
			a++;
			b=1;
		}
	}
	
	public static void prn02() {
		int i = 2;
		int j = 1;
		int mul = 0;
		for (i=2; i<10; i++) {
			System.out.println("<<< " + i + "단 >>>");
			for (j=1; j<10; j++) {
				mul = i*j;
				System.out.println(i + " * " + j + " = " + mul);
			}
		}
	}
}
