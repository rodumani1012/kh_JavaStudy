package com.if01;

public class IfTest01 {
	
	public static void main(String[] args) {
		prn01();
		prn02(false, false);
	}
	
	public static void prn01() {
		int i = 10;
		int j = 20;
		
		// if
		if (i>0) {
			System.out.println(i+"은(는) 0보다 큽니다.");
		}
		
		// if ~ else
		if (i<10) {
			System.out.println(i+"은(는) 10보다 작습니다.");
		} else {
			System.out.println(i+"은(는) 10보다 작지 않습니다.");
		}
		
		// if ~ else if
		if (i>j) {
			System.out.printf("%d 은(는) %d 보다 큽니다.\n",i,j);
		} else if(i==j) {
			System.out.printf("%d 은(는) %d 와 같습니다.\n",i,j);
		} else if (i<j) {
			System.out.printf("%d 은(는) %d 보다 작습니다.\n",i,j);
		} else {
			//else는 위 조건이 모두 거짓일때 사용
			System.out.println("이상하다");
		}
			
	}

	public static void prn02(boolean ring, boolean married) {
		
		if (ring) {
			if(married) {
				System.out.println("결혼하셨군요");
			}else {
				System.out.println("애인이 있군요");
			}
		} else {
			if(married) {
				System.out.println("결혼했는데 반지가 없군요");
			}else {
				System.out.println("솔로...ㅠㅠ");
			}
		}
		
		if(married) {
			System.out.println("결혼했군요");
		}else if( !married && ring) {
			System.out.println("연인이 있으시군요");
		}else {
			System.out.println("솔로");
		}
	
	}
	
}
