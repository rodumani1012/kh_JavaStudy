package com.test01;

public class MTest {

	public static void main(String[] args) {
		// 1. class diagram을 참고하여 Weather class를 만들자.
				
		// 2. Weather class의 prn 메소드는
		// 1~12 사이의 숫자 하나를 받아서
		// 3~5는 봄, 6~8은 여름, 9~11은 가을
		// 나머지는 겨울 이라는 문자열을
		// 리턴하는 메소드 이다.(삼항연산자 사용)
				
		// 3. MTest의 main 메소드에서 자기가
		// 원하는 숫자를 넣어서 호출하자.
		
		Weather w1 = new Weather();
		w1.prn(1);
	}
}
