package com.cal02;

import java.util.Calendar;

public class CalendarUseApi {

	// java.util.Calendar
	public void prn(int year, int month) {

		// Calendar 생성 : singleton pattern
		// Class 변수 = new Class(); (X)
		Calendar cal = Calendar.getInstance();
//		System.out.println(cal.getTime());

		// 가장 윗 부분
		System.out.printf("\t\t%d년 %d월 \n", year, month);
		System.out.printf("일\t월\t화\t수\t목\t금\t토\n");

		// 1. 시작 날짜 설정 (year년도 month월 1일)
		cal.set(year, month - 1, 1);

		// 2. 설정된 날짜의 요일 //Calendar.DAY_OF_WEEK -> 해당 요일 리턴
		int start = cal.get(Calendar.DAY_OF_WEEK); // 그 주의 날짜(1: 일, 2: 월..7: 토)

		// 3. 해당 요일만큼 빈공간
		for (int i = 1; i < start; i++) {
			System.out.printf("\t");
		}

		// 4. 마지막 요일까지 출력 //
		// cal.getActualMaximum(Calendar.DATE)  -> 실제 마지막 날짜(31,30,29,28)
		for (int i = 1; i <= cal.getActualMaximum(Calendar.DATE); i++) {
			System.out.printf("%d\t", i);
			if (start % 7 == 0) {
				System.out.println();
			}
			start++;
		}

	}
}
