package com.test01;

public class ArrayTest02 {

	public static void main(String[] args) {

		// 방법 1.			행 열		 012
		int[][] a = new int[3][3]; // 0 □□□
									// 1 □□□
									// 2 □□□
		a[0][0] = 1;
		a[0][1] = 2;
		a[0][2] = 3;

		a[1][0] = 4;
		a[1][1] = 5;
		a[1][2] = 6;

		a[2][0] = 9;				//a = 1 2 3
		a[2][1] = 8;				//    4 5 6
		a[2][2] = 7;				//    9 8 7

		System.out.println(a[0]); // a 0번지의 주소값
		System.out.println(a[0][1]);


		// 방법 2.
		int [][] b = new int[3][];
		b[0] = new int[5];			// 0 □□□□□
		b[1] = new int[3];			// 1 □□□
		b[2] = new int[8];			// 2 □□□□□□□□

		prn(b);

		// 방법 3.
		int[][] c = new int[][] {
			{1,2},			// 0 □□
			{3,4,5,6},		// 1 □□□□
			{7},			// 2 □
			{8,9,10}		// 3 □□□
		};

		prn(c);
		System.out.println(c[0][0] + c[3][2]);

		// 방법 4.
		int[][] d = {{1,2,3,4},{5,6,7},{8},{9,10}};
		prn(d);

		// 문제1. nice => good, 어려워 => 쉬워 // 변경 후 전체 출력.
		String[][] s = {
				{"have","a","nice","day"},
				{"너무","어려워"},
				{"배열","이차원배열","재밌다"},				
		};
		s[0][2] = "good";
		s[1][1] = "쉬워";	
		s[2][2] = "노잼ㅋ";
		modi(s);
	}

	public static void prn(int[][] arr) {
		for(int i=0; i<arr.length; i++) {
			for (int j =0; j<arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();	
		}			
	}

	public static void modi(String[][] arr) {
		for(int i =0; i< arr.length; i++) {
			for(int j =0; j<arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			} 
			System.out.println();			
		}
	}
}
