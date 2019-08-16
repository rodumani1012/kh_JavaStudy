package com.test01;

public class MTest {

	public static void main(String[] args) {
		AA a = new AA();
		Super s = a; //부모타입은 자식객체를 받을 수 있다.
		// Super s = new AA();
		BB b = (BB) s; //AA != BB
	}
}
