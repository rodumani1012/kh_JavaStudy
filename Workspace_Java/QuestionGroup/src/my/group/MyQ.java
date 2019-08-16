package my.group;

import java.text.DecimalFormat;

public class MyQ {
	private int kor, eng, math;
	int sum;
	double avg1, avg2;
	DecimalFormat d1 = new DecimalFormat("#.##");
	
	public static void main(String[] args) {
		
		MyQ s1 = new MyQ();
		s1.setting1(100, 33, 100);
		
		MyQ s2 = new MyQ();
		s2.setting2(200, 200, 200);
		
		System.out.println(s1.cov(s1.avg1, s2.avg2));
		
	}
	
	public void setting1(int kor1, int eng1, int math1) {
		int sum1 = getSum(kor1, eng1, math1);
		avg1 = getAvg(sum1);
		System.out.println("첫번째 학생의 평균점수는 " + d1.format(avg1) + "입니다.");
		
	}
	
	public void setting2(int kor2, int eng2, int math2) {
		int sum2 = getSum(kor2, eng2, math2);
		avg2 = getAvg(sum2);
		System.out.println("두번째 학생의 평균점수는 " + d1.format(avg2) + "입니다.");
	}
	
	public boolean cov(double a, double b) {
		boolean c = (a>b)?true:false;
		return c;
	}
	
	public static int getSum(int i, int j, int k) {
		int summary = i + j + k;
		
		return summary;
	}
	
	public static double getAvg(int avg) {
		double average = (double) avg/3;
		
		return average;
	}
}
