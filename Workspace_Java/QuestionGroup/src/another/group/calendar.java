package another.group;

import java.util.Calendar;
import java.util.Scanner;

public class calendar {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		Scanner s1 = new Scanner(System.in);

		System.out.println("년도를 입력하세요 : ");
		int year = s1.nextInt();
		System.out.println("월 입력하세요 : ");
		int month = s1.nextInt();
		
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		
		System.out.println("-------------  " + year +"년 " + month + "월  " + "-------------");
		System.out.println("일    월    화    수    목    금    토");
		
		cal.set(year, month-1, 1); //입력받은 년,월의 1일로 초기값 셋팅.
								   //month는 0이 1월이므로 -1
		
		int mEnd = cal.getActualMaximum(Calendar.DAY_OF_MONTH); //월의 마지막 날짜
		int week = cal.get(Calendar.DAY_OF_WEEK); //해당 날짜 요일(1:일, 2:월... 7:토)
		
		
		s1.close();
		System.out.println("스캐너 종료");
	}

}
