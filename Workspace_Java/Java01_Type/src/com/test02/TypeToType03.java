package com.test02;

public class TypeToType03 {

	public static void main(String[] args) {
		
		// Type 변수 = 값; 
		// 참조변수
		
		// 기본 타입을 참조타입으로 바꾸는 것을 boxing, 그 반대를 unboxing
		// => boxing 하게되면 i. 을 통해 class를 활용할 수 있지만 unboxing 된 기본타입 값은 j. k. 등등 활용 불가능하다.
		
		//boxing
		Integer i = new Integer(100); // i는 100값을 갖고있는 것의 주소값 => 이를 boxing했다고 함.
		System.out.println(i);
		
		System.out.println("================");
				
		//unboxing
		// 명시적
//		int j = i.intValue();
		String j = i.toString();
		
		// 묵시적
		int k = i;
		System.out.println(j);
		System.out.println(k);
	}

}
