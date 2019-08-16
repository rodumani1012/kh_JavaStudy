package com.test03;

import java.text.DecimalFormat;

public class Score {
	
	public String student(String a, int kor, int eng, int math) {
		int sum = getSum(kor, eng, math);
		double avg = getAvg(sum);
		String grade = getGrade(avg);
		
		DecimalFormat d1 = new DecimalFormat("#.##");
		
		return a + "님의 총점은 " + sum + "점, 평균은 " + d1.format(avg) + "점, 등급은 " + grade +"입니다.";
	}
	
	// 3개의 파라미터를 모두 더해서
	// 리턴하는 기능을 가진 getSum메소드
	public int getSum(int kor, int eng, int math) {
		int res = kor + eng + math;
		return res;
	}
	
	// 하나의 파라미터를 받아서
	// 3으로 나눈 값을 리턴하는 기능
	// (실수 값 리턴)
	public double getAvg(int sum) {
		double avg = (double)sum/3;
		return avg;
	}
	
	// 하나의 파라미터를 받아서
	// 해당 값이 90~100 이면 A , 80~89 B, 70~79 C, 60~69 D, 60미만 F 를 리턴하는 기능
	public String getGrade(double avg) {
		// 내 if 버전
//		if ((avg>=90) && (avg<=100)) {
//			return "A";
//		} else if ((avg>=80) && (avg<90)) {
//			return "B";
//		} else if ((avg>=70) && (avg<80)) {
//			return "C";
//		} else if ((avg>=60) && (avg<70)) {
//			return "D";
//		} else {
//			return "F";
//		}		
		
		// 내 switch 버전		
		switch ((int)avg/10) {
		case 10:
		case 9:
			return "A";
		case 8:
			return "B";			
		case 7:
			return "C";		
		case 6:
			return "D";
		default:
			return "F";
	}
}
		//강사님
//		String res = "";
//		
//		switch ((int)avg/10) {
//		case 10:
//		case 9:
//			res = "A";
//			break;
//		case 8:
//			res = "B";
//			break;	
//		case 7:
//			res = "C";
//			break;
//		case 6:
//			res = "D";
//			break;
//		default:
//			res = "F";
//			break;
//		}
//		return res;
		
}
