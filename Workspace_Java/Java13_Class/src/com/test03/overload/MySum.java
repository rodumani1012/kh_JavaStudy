package com.test03.overload;

public class MySum {
	
	// 같은 메소드 이름으로 다른 역할을 하는 것.
	// 리턴타입 또는 파라미터 갯수로 여러개 생성 가능.
	public void sum(int i) {
		System.out.println(i+i);
	}
	
	public int sum() {
		
		return 0;
	}
	
	public int sum(int i, int j) {
		return i+j;
	}
	
	public int sum(int i, int j, int k) {
		return i+j+k;
	}
	
	public double sum(double i, double j) {
		return i+j;
	}
	
	
}
