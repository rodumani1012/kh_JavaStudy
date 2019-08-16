package com.java04_array;

import java.util.Arrays;

public class MTest {

	public static void main(String[] args) {
		Person[] Q = new Person[6];
		Q[0] = new Person("정서희", 25);
		Q[1] = new Person("신희수", 24);
		Q[2] = new Person("문희수", 24);
		Q[3] = new Person("정지예", 26);
		Q[4] = new Person("한지수", 27);
		Q[5] = new Person("최준연", 26);
		System.out.println(Arrays.toString(Q));
		prn(Q);
 	}
	
	public static void prn(Person[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i].getName());
		}
	}
}
