package com.java01_type;

public class MTest {
	
	public static void main(String[] args) {
		// type 변수 = 값;
		int i = 10;
		Integer wrapI = new Integer(10);
		System.out.println(i==wrapI); // wrapI는 묵시적으로 unboxing 되서 값이 비교 가능한 것.
		System.out.println(wrapI);
		
		String s01 = "a"; // String은 참조타입인데 기본타입처럼 쓸 수 있다.
		String s02 = new String("a"); // s02는 기존 s01의 a와는 다른 장소에 저장.
		String s03 = "a";
		System.out.println(s01==s02); // 주소값 비교
		System.out.println(s01==s03); // string pool에 같은 값이 저장되서 주소가 같다. 
		System.out.println(s01.equals(s02)); // 값 비교
		
		s01 = s01 + "b"; //값을 추가할 때 StringBuilder 라는 얘가 도와주는데 이때 주소가 달라지게 된다.
		s02 = s02 + "b";
		System.out.println(s01 == s02); 
		
		
	}
}
