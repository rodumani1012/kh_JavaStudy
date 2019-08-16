package exception.ex;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exception2 {

	// 1. 랜덤값으로 나눴다!
	// 2. 입력한 값으로 나눠보자!
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 결과값 담을 변수
		int res = 0;
		
		System.out.println("나눌 숫자 하나 입력!:");
		
//		try {
//			int num = sc.nextInt();
//			res = 10/num;
//			System.out.println(res);
//		} catch (Exception e) {
//			System.out.println("예외 발생!!");
//		}
		
		try {
			int num = sc.nextInt();
			res = 10/num;
			System.out.println(res);
		} catch (ArithmeticException e) {
			System.out.println("0을 넣었습니다..");
		} catch (InputMismatchException e) {
			System.out.println("문자를 넣었습니다..");
		} catch (Exception e) {
			System.out.println("0이나 문자를 입력하였습니다.");
		}
		
		
		
	}
}
