package com.SumX;

public class SumX {
	/*0,4 1,3 2,2 3,1 4,0
	 *   1  2  3  4  5
	 *   6  7  8  9 10
	 *  11 12 13 14 15
	 *  16 17 18 19 20
	 *  21 22 23 24 25
	 *  
	 *  X모양 대각선의 합을 출력하자.
	 *  정답 : 117
	 */
	
	// 내가 한 것
//	public static void main(String[] args) {
//		int i = 1;
//		int sum = 0;
//		for (i = 1; i < 26; i++) {
//			System.out.print(i);
//			if (i%5 ==0) {
//				System.out.println();
//			}
//			if ((i%6 ==1) || (i%4==1)) {
//				sum +=i;
//			}
//		}
//		System.out.println("대각선의 합은 : " + sum + " 입니다.");
//	}
	
	//강사님
	public static void main(String[] args) {
		int i = 0;
		int j = 0;
		int count = 1;
		int x = 0;
		int sum = 0;
		for (i = 0; i<5; i++) {
			
			for (j = 0; j<5; j++) {
					sum += count;
				if ((i==j) || (i+j==4)) {
					x += count;
				}
				System.out.printf("%3d", count++);
			}
			System.out.println();
		}
		System.out.println("대각선 총합 : " + x);
		System.out.println("총 합 : " + sum);
		System.out.println("평균 : " + sum/(count-1)); //26이 콘솔에 찍히진 않았지만 45번 라인에서
												    //count++ 되어서 현재 count는 26으로 -1 해준다.
	}
	
	// 숙제. 위 문제에서 대각선 총합뿐만 아니라 총합, 평균까지 출력하시오.
}
