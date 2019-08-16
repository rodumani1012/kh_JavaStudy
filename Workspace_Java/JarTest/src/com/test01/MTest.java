package com.test01;

public class MTest {

	public static void main(String[] args) {
		//java project 우클릭 => properties => Java Bulid Path => Libraries => Add External JARs
		Score hong = new Score("홍길동", 100, 100, 95);
		
		System.out.println(hong);
	}
}
