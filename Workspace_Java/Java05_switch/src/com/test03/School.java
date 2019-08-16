package com.test03;

public class School {

	public static void main(String[] args) {
		String name = "최준연";
		int kor = 90;
		int eng = 90;
		int math = 90;
		
		//강사님
		Score sc = new Score();
		
		int sum = sc.getSum(kor, eng, math);
		double avg = sc.getAvg(sum);
		String grade = sc.getGrade(avg);
		
		System.out.printf("%s 님의 총점은 %d점, 평균은 %.2f점, 등급은 %s 입니다.", name, sum, avg, grade);
		
		
		//내가 한것
//		Score s1 = new Score();
//		System.out.println(s1.student(name, kor, eng, math));
		
		// ~~님의 총점은 ㅁ점, 평균은 ㅁ점, 등급은 ㅁ입니다.
	}
}
