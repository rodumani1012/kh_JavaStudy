package com.test01;

public class StringBufferTest {

	public static void main(String[] args) {
//		sTest();
		sBufferTest();
	}
	
	// String을 + 연산 할 때,
	// 내부적으로 StringBuilder라는 객체가
	// 더해서 만들어 준다.
	public static void sTest() {
		String s = "안녕하세요. ";
		s += "저는 ";
		s += "최준연 입니다.";
		s += "잘 부탁 드립니다.";
		System.out.println(s);
		System.out.println(s.hashCode()); //해시코드가 문장을 추가할 때마다 다 다름.
		
		s.replace("안녕하세요", "하이");
		System.out.println(s); //바뀌지 않음.
		
		s = s.replace("안녕하세요", "하이");
		System.out.println(s);
		
		// immutable : 값이 변하지 않는다.
		// (대입을 해야 값이 변한다. 즉, 새로운 객체가 생성된다.)
	}
	
	public static void sBufferTest() {
		StringBuffer sb = new StringBuffer();
		sb.append("안녕하세요. ").append("저는 ").append("최준연 입니다.");
		sb.append("잘 부탁 드립니다."); //문장을 추가해도 hashcode는 바뀌지 않았음.
		System.out.println(sb);
		System.out.println(sb.hashCode()); 
		
		sb.replace(0, 5, "하이");
		System.out.println(sb);
		
		sb.reverse();
		System.out.println(sb);
		System.out.println(sb.hashCode());
	}
}
