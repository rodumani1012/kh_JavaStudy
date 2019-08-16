package com.test01;

public class MethodTest02 {

	public static void main(String[] args) {
		// 호출 방법
		// 1. static 호출방법 : class.method();
		MethodTest01.publicMethod();
		MethodTest01.protectedMethod();
		MethodTest01.defaultMethod();
//		MethodTest01.privateMethod(); //보이지 않습니다.(private는 같은 class에서 사용가능)
//		MethodTest01.abc(); //정의되지 않았습니다. (없습니다.)

		/*
		 * 2. non-static 호출방법 : class classVal = new class();
		 * 	  						classVal.method();
		 */	 
		MethodTest01 m1 = new MethodTest01();
		m1.nonStaticMethod();
		m1.defaultMethod();//non-static에서 static을 부를 수 있지만 전체에 영향을 줄 수 있어 조심해야한다.
		
		// http://www.objectaid.com
		// uml : Unified Modeling Language
	}

}
