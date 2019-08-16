package com.score;

public class MTest {

	public static void main(String[] args) {
		Score song = new Score();
		song.setName("송치윤");
		song.setKor(100);
		song.setEng(20);
		song.setMath(50);
		System.out.println(song); //Score 클래스에서 toString() 메소드를 @Override 하지 않았다면 주소값이 출력되었을 것이다.
		
		Score jeong = new Score("정민호", 55, 73, 100);
		System.out.println(jeong);
		// "홍길동 국어 : 55 영어 : 73 수학 : 100"
		// "총점 : ? 평균 : ? 등급 : ?"
		// toString() 메소드에 출력 명령.
	}
}
