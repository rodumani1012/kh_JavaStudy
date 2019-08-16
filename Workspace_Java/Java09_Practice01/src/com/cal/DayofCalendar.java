package com.cal;

import java.util.Scanner;

public class DayofCalendar {
	static Scanner sc = new Scanner(System.in);
	
	// 1. 윤년 계산	
	public static boolean isLeapYear(int year) {
		boolean leap = false;
		if ((year%4 == 0)&&(year%100 != 0)||(year%400 ==0)) {
//			System.out.println("윤년입니다.");
			leap = true;
		} else if ((year%4 != 0) || (year%100 == 0)&&(year%400 != 0)) {
			leap = false;
//			System.out.println("평년입니다.");
		}
		
		return leap;
	}
	
	// 2. 일수 계산(일의 갯수 : ex)2004년 2월 => 29일)
	public static int dates(int year, int month) {
		// 해당 년도가 윤년이라면
		// 1,3,5,7,8,10,12 : 31일
		// 4,6,9,11 : 30일
		// 2 : 29
		// 윤년이 아니라면 2 : 28을 리턴하자
		int temp = 0;
		
		if (isLeapYear(year)) {
			//switch 방식
			switch(month) {
			case 1: case 3: case 5: case 7: case 8: case 10: case 12:
				temp = 31;
				break;			
			case 4: case 6: case 9: case 11:
				temp = 30;
				break;
			case 2: 
				temp = 29;
				break;
			}
		} else {
			//if else 방식
			if(month==1 || month==3 || month==5 || month==7
					|| month==8 || month==10 || month==12) {
				temp = 31;
			} else if(month==4|| month==6 || month==9 || month==11) {
				temp = 30;
			} else if(month==2) {
				temp = 28;
			}
		}
		return temp;
		
	}
	// 3. 요일 계산 
	public static void main(String[] args) {
		// 총 일수를 저장한다.
		int sum = 0;
		
		int year = 2019;
		int month = 2;
		int day = 25;
		
		// 1년 1월 1일 ~ 2018년 12월 31일까지의 합
		for (int i = 1; i<year; i++) {
			for(int j = 1; j<13; j++) {
				sum += dates(i,j); //해당 년도 해당 월의 일수를 전부 더함.
			}
		}
		// 2019년 1월 1일부터 ~ 2019년 1월 31일까지의 합
		for (int i = 1; i<month; i++) {
			sum += dates(year, i);
		}
		
		// 2019년 2월 1일부터 ~2월 25일까지의 합
		sum += day;
		
		// sum%7 해서 요일 출력
		System.out.printf("%d 년 %d 월 %d일은 %s 입니다.",
				year, month, day, dayMode(sum%7));
	}
	
	public static String dayMode(int day) {
		String tmp = "";
		
		switch(day) {
		case 0:
			tmp = "일요일";
			break;
		case 1:
			tmp = "월요일";
			break;
		case 2:
			tmp = "화요일";
			break;
		case 3:
			tmp = "수요일";
			break;
		case 4:
			tmp = "목요일";
			break;
		case 5:
			tmp = "금요일";
			break;
		case 6:
			tmp = "토요일";
			break;
		}
		
		return tmp;
	}
	// "~년 ~월 ~일은 ~요일 입니다.
}
