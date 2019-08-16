package com.test03;

public class Student {
	private String myName;
	private int myAge;

	public void setting(String name, int age) {
//		String res = prn(name, age);
//		System.out.println(res);
		System.out.println(prn(name,age));
	}

	private String prn(String name, int age) {
		return "제 이름은 " + name + "이고, " + "나이는 " + age + " 입니다.";
	}
	/*
	 * 내가 한 것
	 * public void setting(String name, int age) { 
	 * 	myName = name; 
	 *  myAge = age;
	 *  prn(myName, myAge);
	 * }
	 * 
	 * private String prn(String name, int age) {
	 *  System.out.println("제 이름은 " + myName + "이고, " + "나이는 " + myAge + " 입니다." );
	 *  return "";
	 * }
	 */

}