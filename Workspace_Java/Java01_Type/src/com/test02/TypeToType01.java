package com.test02;

public class TypeToType01 {

	public static void main(String[] args) {
		// 묵시적 형변환
		// (upCasting : 작은 타입에서 큰 타입으로)
		// promotion 이라고 함
		byte b01 = 100;
		int i01 = b01;
		System.out.println(i01);
		
		// 명시적 형변환
		// (downCasting : 큰 타입에서 작은 타입으로)
		// casting 이라고 함
		int i02 = 100;
		byte b02 = (byte) i02;
		System.out.println(i02);
	}
}
