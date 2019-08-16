package com.test02;

public class MyCalcMain {

	public static void main(String[] args) {
		MyCalc.sum(10, 2);
		int sub = MyCalc.sub(10, 2);
		System.out.println("빼기 : " + sub);
		
//		double mul = MyCalc.mul(10, 2);
//		System.out.println("곱하기 : " + mul);
		System.out.println("곱하기 : " + MyCalc.mul(10.2, 2)); //돌려주는 값이 있어 오류가 없다.

		MyCalc.div(10, 3);
//		System.out.println(MyCalc.div(10, 3)); // (div메소드는 return type이 void이기 때문에)
											   // 돌려주는 값이 없어 오류 난다.
//		int div = MyCalc.div(10, 3);		   // 마찬가지.
	}
	

}
