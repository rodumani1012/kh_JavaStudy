package com.random;

public class RandomCube {
	// 0~9 사이의 랜덤한 수 25개를 출력하시오
	public static void main(String[] args) {
		
		int sum = 0;
		int cnt = 0;
		
		for (int i=0; i<5; i++) {
			for(int j=0; j<5; j++ ) {		
				int res = (int)(Math.random()*10); //0~9사이
					if((i==j)||(i+j==4)) {
						sum += res;
					}
				System.out.print(res + " ");
				cnt++;
			}
		System.out.println();
		}
		System.out.println("대각선의 총합 : " + sum);
		System.out.println("대각선의 평균 : " + (double) sum/cnt + "\t나머지 : " + sum%cnt);
	}
	
	
}
