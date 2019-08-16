package com.test02;

import com.test01.MethodTest01;

public class MethodTest03 extends MethodTest01{

	public static void main(String[] args) {
		MethodTest01.publicMethod();
		MethodTest01.protectedMethod(); //import가 상속한것이 아닌가?? 아닙니다. extends 가 상속입니다.
	}

}
