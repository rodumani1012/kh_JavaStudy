package com.test02;

public class TypeToType02 {
	//아스키코드표에 따라 숫자를 문자로, 문자를 숫자로 바꾸는 연습
	public static void main(String[] args) {
		
		// 1. int to char
		int i = 65;
		char c = (char) i;
		System.out.println("int to char : " + c);
		
		// 2. char to int
		char c01 = 'a';
		int i01 = c01;
		System.out.println("char to int : " + i01);
		
		// 3. 
		char c02 = '9';
		char c03 = '1';
		int i02 = c02 + c03;
		System.out.println(c02 + "+" + c03 + "=" + i02);
		
		// 4. String to int
		String str = "66";
		int i03 = Integer.parseInt(str);
		System.out.println("String to int : " + i03);
	}

}
