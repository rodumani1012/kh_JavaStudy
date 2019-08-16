package com.cal01;

public class DayOfCalendar {

	// 윤년 계산
	public static boolean leapYear(int year) {
		boolean leap = false;
		if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
			leap = true;
		} 
		return leap;
	}

	// 일 수 계산
	public static int dates(int year, int month) {

		if (leapYear(year)) {
			switch (month) {
			case 1:	case 3:	case 5:	case 7:	case 8:	case 10:case 12:
				return 31;
			case 4:	case 6:	case 9:	case 11:
				return 30;
			case 2:
				return 29;
			}
		} else {
			switch (month) {
			case 1:	case 3:	case 5:	case 7:	case 8:	case 10:case 12:
				return 31;
			case 4:	case 6:	case 9:	case 11:
				return 30;
			case 2:
				return 28;
			}
		}
		return 0;
	}

	// 요일 계산 (년, 월, 1일의 요일)
	public static int whatDay(int year, int month) {
		int dayOfWeek = 0;
		int sum = 0;

		// 1년 1월 1일 ~ year-1년 12월 31일
		for (int i = 1; i < year; i++) {
			for (int j = 1; j < 13; j++) {
				sum += dates(i, j);
			}
		} 

		// year년 1월 1일 ~ year년 month-1월 마지막 일 
		for (int i = 1; i < month; i++) {
			sum += dates(year, i);
		}

		// 아직 sum 의 값은 year년 month-1월 마지막날 이므로
		// +1을 해줘야 year년 month월 1일 이 나온다.
		sum += 1;

		// 요일(0: 일, 1: 월...., 6:토)
		dayOfWeek = sum % 7;
		return dayOfWeek;
	}

	// 출력
	public static void prn(int year, int month) {
		
		System.out.printf("\t\t%d년 %d월 \n", year, month);
		System.out.printf("일\t월\t화\t수\t목\t금\t토\n");
		
		//달력의 시작 요일
		int start = whatDay(year, month);
		// 마지막 날짜
		int last = dates(year, month);
		
		// 1일의 요일만큼 빈칸 생성. ex) 2019.02월은 금요일이 1일이므로 월~목을 공백으로.
		for(int i =0; i<start; i++) {
			System.out.print("\t");	
		}
		start++; //start의 최대값은 6인데 7이 되야 엔터가 쳐지므로 ++을 해준다.
		for(int i=1; i<=last; i++) {
			System.out.printf("%d\t",i);
			if(start%7==0) {
				System.out.println();
			}
			start++;
		}
		
	}

}
