package com.cal;
/*
 * ① 서력 기원 연수가 4로 나누어 떨어지는 해는 우선 윤년으로 하고, 
 * ② 그 중에서 100으로 나누어 떨어지는 해는 평년으로 하며, 
 * ③ 다만 400으로 나누어 떨어지는 해는 다시 윤년으로 정하였다. 
 *    이로써 1년의 평균길이를 365.2425일로 정하여 역에 썼으므로 실제의 1년보다 0.0003일이 길다.
 */

import java.util.Scanner;

public class LeapYear {

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		//내꺼
//		LeapYear ly = new LeapYear();
//		for(;;) {
//			ly.leapYear();
//		}
		
		//강사님
		Scanner sc = new Scanner(System.in);
		System.out.println("년도를 입력하세요 : ");
		int year = sc.nextInt();
		
		if (isLeapYear(year)) {
			System.out.println(year + "년은 윤년이 맞습니다.");
		} else {
			System.out.println(year + "년은 평년입니다.");
		}
	}
	
	public void leapYear() {
		System.out.println("년도를 입력하세요 : ");
		int year = sc.nextInt();

		if (year%4 ==0) {
			if (year%100 ==0) {
				if(year%400 ==0) {
					System.out.println("윤년입니다.");
				} else {
					System.out.println("100 ok 400 x 평년");
				}
			} else {
				System.out.println("4 ok 100 x 윤년");
			}
		} else {
			System.out.println("4 x 평년");
		}

//		if ((year%4 == 0)&&(year%100 != 0)||(year%400 ==0)) {
//			System.out.println("윤년입니다.");
//		} else if ((year%4 != 0) || (year%100 == 0)&&(year%400 != 0)) {
//			System.out.println("평년입니다.");
//		}
	}
	
	//강사님
	public static boolean isLeapYear(int year) {
		boolean leap = false;
		if ((year%4 == 0)&&(year%100 != 0)||(year%400 ==0)) {
			System.out.println("윤년입니다.");
			leap = true;
		} else if ((year%4 != 0) || (year%100 == 0)&&(year%400 != 0)) {
			leap = false;
			System.out.println("평년입니다.");
		}
		
		return leap;
	}
	
}
