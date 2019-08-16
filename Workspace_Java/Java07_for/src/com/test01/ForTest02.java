package com.test01;

public class ForTest02 {

	public static void main(String[] args) {
		prn01();
	}
	public static void prn01() {
		
		for(int i=0; i<10; i++) {
			
			for(int j=0; j<10; j++) {
				System.out.println("i : " + i + ", j : " + j);
			}
		}
	}
}
