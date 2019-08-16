package com.star;

public class StarPrn {
	//별찍기 꿀팁
	// 초기값 다 0, 조건에 꺽쇄는 '<', 변수<값, 증감식은 다 ++
	// 출력시 원하는 갯수만큼의 정수를 조건에 값으로 넣어줌
	// 별의 증감에 따라 조건값에 연산을 넣어줌.
	

	/*
	 * ★
	 * ★★
	 * ★★★
	 * ★★★★
	 * ★★★★★
	 */
	public void starOne() {
		// i는 줄
		for(int i=0; i<5; i++) {
			// j는 ★  0,1 1,2 2,3 3,4 4,5
			for(int j=0; j< i+1; j++) {
				System.out.print("★");
			}
			System.out.println();
		}
	}
	
	/*
	 * ★★★★★
	 * ★★★★
	 * ★★★
	 * ★★
	 * ★
	 */	
	public void starTwo() {
		for(int i = 0; i<5; i++) {
			// 5,0 5,1 5,2 5,3 5,4
			for(int j = 5; j > i; j--) { //for(int j=0; j<5-i; j++)
				System.out.print("★");
			}
			System.out.println();
		}
	}
	
	/*
	 *     ★
	 *    ★★
	 *   ★★★
	 *  ★★★★
	 * ★★★★★
	 */
	public void starThree() {
		for(int i =0; i<5; i++) {
			// 4,1 3,2 2,3 1,4 0,5			
			// 방법1 for와 if
			for(int j=0; j<5; j++) {
				if (j<4-i) {
					System.out.print(" ");
				} else {
					System.out.print("★");
				}
			}
			// 방법2 for 2개로
//			for(int j =0; j<4-i; j++) {
//				System.out.print(" ");
//			}
//			for(int k=0; k<1+i; k++) {
//				System.out.print("★");
//			}
			System.out.println();
		}
	}	
	
	public void starThreeTeacher() {
		for(int i =0; i<5; i++) {
			// 4,1 3,2 2,3 1,4 0,5
			for(int j=0; j<4-i; j++) {
				System.out.print(" ");
			}
			for(int k=0; k<1+i; k++) {
				System.out.print("★");
			}
			System.out.println();	
	}
}
	/*
	 * ★★★★★
	 *  ★★★★
	 *   ★★★
	 *    ★★
	 *     ★
	 */	
	public void starFour() {
		for(int i =0; i<5; i++) {
			for(int j=1; j<6; j++) {
				if(i<j) {
					System.out.print("★");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	public void starFourTeacher() {
		for(int i =0; i<5; i++) {
			//0,5 1,4 2,3 3,2 4,1
			for(int j=0; j<i; j++) {
				System.out.print(" ");
			}
			for(int k=0; k<5-i; k++) {
				System.out.print("★");
			}
			System.out.println();
		}
	}
	
	/*
	 *     ★
	 *    ★★★
	 *   ★★★★★
	 *  ★★★★★★★
	 * ★★★★★★★★★
	 */
	public void starFive() {
		for(int i=0; i<5; i++) {
			// 1, 3, 5, 7, 9
			for(int j=0; j<4-i; j++) {
				System.out.print(" ");
			}
			for(int k=0; k<2*i+1; k++) {
				System.out.print("★");			
			}
			System.out.println();
		}
	}
	/*
	 *     ★
	 *    ★★★
	 *   ★★★★★
	 *  ★★★★★★★
	 * ★★★★★★★★★
	 */
	public void starFiveIf() {
		for(int i=0; i<5; i++) {
			// 1, 3, 5, 7, 9
			for(int j=0; j<5; j++) {
				if (j<4-i) {
					System.out.print("?");
				} 

				else if (j<5+2*i){
					System.out.print("★");							
				}
				else if (j<6+2*i){
					System.out.print("★");							
				}
			}
			System.out.println();
		}
	}
	/*
	 *     ★
	 *    ★★★
	 *   ★★★★★
	 *  ★★★★★★★
	 * ★★★★★★★★★
	 *  ★★★★★★★
	 *   ★★★★★
	 *    ★★★
	 *     ★
	 */
	public void diamond() {
		for(int i=0; i<5; i++) {
			for(int j=0; j<4-i; j++) {
				System.out.print(" ");
			}
			for(int k=0; k<1+2*i; k++) {
				System.out.print("★");
			}
			System.out.println();
		}
		for(int i=0; i<5; i++) {
			for(int j=0; j<1+i; j++) {
				System.out.print(" ");
			}
			for(int k=0; k<7-2*i; k++) {
				System.out.print("★");
			}
			System.out.println();
		}
	}
	
	
	
}
