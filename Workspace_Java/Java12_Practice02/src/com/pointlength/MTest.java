package com.pointlength;

import java.util.Scanner;

public class MTest {
	
	//원점부터 입력한 점 사이의 거리를 구하자.
	//Math class 활용
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("x 좌표 입력 : ");
		int x = sc.nextInt();
		System.out.println("y 좌표 입력 : ");
		int y = sc.nextInt();
		
		System.out.printf("0,0 부터 %d,%d 까지의" + " 거리는 %f 입니다.",x,y,pLength(x, y));
	}
	
	public static double pLength(int x, int y) {
		double p = 0;
		// Math.sqrt
		p = Math.sqrt(x*x + y*y); //루트는 sqrt
//		p = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)); //제곱은 pow
		
		return p;
	}
}
