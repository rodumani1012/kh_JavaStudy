package com.test03.overload;

public class MTest {

	public static void main(String[] args) {
		MySum my = new MySum();
		
		System.out.println(my.sum());
		my.sum(1);
		System.out.println(my.sum(1, 2));
		System.out.println(my.sum(1, 2, 3));
		System.out.println(my.sum(1.2, 3.4));
		
		
		// 오버로딩 : 같은 이름으로 일관성있는 다른 행동을 하는 것.
	}
}
