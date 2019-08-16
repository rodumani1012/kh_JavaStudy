package com.pointlength;

public class HwaC_SubC {

	public static void main(String[] args) {

		System.out.println(change(27));
	}

	private static double change(int a) {
		// 화씨('f) 공식 : f = c*9/5+32
		double res = (double)(a-32)/9*5;
		return res;
	}
}
