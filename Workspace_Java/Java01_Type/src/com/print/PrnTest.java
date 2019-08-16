package com.print;

public class PrnTest {

	public static void main(String[] args) {
		/*
		 * 	System.out.print();		- 줄 바꿈 없음
		 * 	System.out.println();	- 줄 바꿈 포함
		 * 	System.out.printf();	- 'formatter' (자리 or 형식)
		 * 
		 * 	System.out.printf(String format, Object, ...args)
		 *									// 1 more
		 *	java.util.Formatter
		 */
		
		int i = 100;
		System.out.print("1. i= " + i + " ");
		System.out.println("2. i= " + i);
		System.out.printf("3. i=%10d ", i);

		System.out.println(" ======================== ");
		
		int su = 100;
		char ch = 'A';
		double d = 90.50d;
		
		/*
		 * %s : String		%f : float
		 * %d : digit		%n : new line
		 */
		System.out.println("시험 점수 결과는 " + su + "점이고, ");
		System.out.printf("시험 점수 결과는 %d점이고, 학점은 '%c'가 나왔다.\n 나의 오늘 감정지수는%.2f%%이다.", su, ch, d);

		/*
		 * escape 문자 : \n : 줄바꿈				\t : 탭
		 * 				 \' : 작은 따옴표			\" : 큰따옴표
		 * 				 \r : 줄의 가장 앞자리로
		 * 
		 */
	}

}
