package com.test02;

public class BreakTest {

	/*
	 * A B C D E
	 * F G H I J
	 * K L M N O
	 * P Q R S T
	 * U V W X Y
	 * Z
	 * 
	 * 를 출력하자
	 */
	
	// 내 방법
//	public static void main(String[] args) {
//		int i = 65;
//		char c;
//		while (i <= 90) {
//			c = (char) i;
//			System.out.print(c + " ");
//				if ((i+1)%5 ==0) {
//					System.out.println();
//				}
//			i++;
//		}
//	}
	
	// 어려운 방법 1
//	public static void main(String[] args) {
//		char start = 'A';
//		char end = 'Z';
//		int count = 0;
//		
//		while ((int)start <= (int)end) {
//			System.out.print(start++);
//			if((++count)%5 ==0) {
//				System.out.println();
//			}
//		}
//	}
	
	// 어려운 방법 2 while, break
	public static void main(String[] args) {
		int count = 0;
		char c = 'A';
		boolean stop = false;
				
		while (!stop) {
			while (true) {
				System.out.print(c);
				c++;
				count++;
				if (count%5 ==0) {
					break;		// break를 통해 최상위 while(!stop)문으로 넘어가서 syso 됨.
				}
				if (count==26) {
					stop=true;
					break;					
				}
			}
			System.out.println();
			}
		}
	
}
