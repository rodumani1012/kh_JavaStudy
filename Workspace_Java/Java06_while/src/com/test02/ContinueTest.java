package com.test02;

public class ContinueTest {

	public static void main(String[] args) {
		int i = 0;
		
		while(i<30) {
			i++;
			
			// 홀수만 출력하자.
			if(i%2==0) {
				continue; // 해당 블럭의 최상위 블럭으로 올라가서 다시 실행함
			}
			
			System.out.println(i);
		}
		
	}

}
