package com.test03;

public class Student {

	public static void main(String[] args) {
		int kor, eng, math;
		kor = eng = math = 0;
		
		kor = 100;
		eng = 40;
		math = 80;
		
		int sum = 0;
		double avg = 0;
		
		System.out.println("총점 : " + getSum(kor, eng, math));
		System.out.println("평균 : " + getAvg(getSum(kor, eng, math)));
		/*
		 * 문제3.
		 * main 메소드에 선언되어있는
		 * sum 변수에 getSum 리턴값을 저장하고,
		 * avg 변수에 getAvg의 리턴값을 저장해서
		 * "총점 : ? 평균 : ?"로 출력하자.
		 */
		sum = getSum(kor, eng, math);
//		avg = getAvg(sum);
		avg = getAvg(getSum(kor, eng, math));
		System.out.println("총점 : " + sum + "  평균 : " + avg);
	}
	/* 
	 * 문제1.
	 * int형 파라미터 3개를 받는 getSum을 만들자.
	 * 리턴타입은 int 이고,
	 * 파라미터로 들어온 값 3개를 모두 더해서
	 * 리턴하는 기능을 한다.
	 */		
	public static int getSum(int i, int j, int k) {
		
		return i + j + k;
	}				
	/*
	 * 문제2.
	 * int형 파라미터 1개를 받는 getAvg를 만들자.
	 * 리턴타입은 double이고,
	 * 파라미터로 들어온 값을 3으로 나누어
	 * 리턴하는 기능을 한다.
	 */
	public static double getAvg(int i) {
		return (double) i/3;
	}	

}
