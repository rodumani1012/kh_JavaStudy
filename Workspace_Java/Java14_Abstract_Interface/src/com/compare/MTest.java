package com.compare;

import java.util.Arrays;

public class MTest {

	public static void main(String[] args) {
		// 1. Score 객체 3개를 만들자 (자신 + 짝궁 2명)
		Score s1 = new Score();
		s1.setName("최준연");
		s1.setKor(100);
		s1.setEng(20);
		s1.setMath(30);
		
		Score s2 = new Score();
		s2.setName("송치윤");
		s2.setKor(100);
		s2.setEng(80);
		s2.setMath(40);
		
		Score s3 = new Score("정민호",89,67,26);
				
		// 2. Score 객체를 관리하는 배열을 만들자
		// 변수이름 : student     크기 : 3
		Score[] student = new Score[3]; //스코어 배열은 스코어 타입만을 담을 수 있다.
										// 참조타입이기에 Score가 타입이 될 수 있다.
										//ex) String[] student = new String[3]; 
										// student[0] = s1; stu~[1] = s2; stu~[2] = s3;  <== 오류발생
		
		// 3. student 배열에 1번에서 만든 객체 3개를 넣어주자.
		student[0] = s1;
		student[1] = s2;
		student[2] = s3;
		
//		for(int i = 0; i<student.length; i++) {
//			System.out.println(student[i]);
//		}
		
		// foreach문 (향상된 for문)
		for(Score s : student) { //student 안에 있는 모든 것들을 s에 대입하자.
			System.out.println(s); //대입된 s를 출력하자.
		}
		System.out.println("=========================");
		
		Arrays.sort(student); //comparable 인터페이스 없어서 오류.
		for(Score s : student) {
			System.out.println(s);
		}
		
		// 국어점수를 가지고 오름차순으로 정렬하자.
		// 만일, 국어점수가 같으면 평균으로 오름차순 정렬하자.
	}
}
