package com.generic;

public class MTest {

	public static void main(String[] args) {
		// generic : 타입을 강제시킨다.
		Emp<String> e1 = new Emp<String>("A1111", "홍길동");
		
		Emp<Integer> e2 = new Emp<Integer>(2222,"이순신");
		
		e1.setEmpno("2222"); //사원번호를 변경시 e1은 String 타입으로 2222가 아닌 "2222"로 넣어야함
		
		System.out.println(e1.getEname() + "의 사원번호" + e1.getEmpno());
		System.out.println(e2.getEname() + "의 사원번호" + e2.getEmpno());
	}
}
