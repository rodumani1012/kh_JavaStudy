package com.bbb;

import com.aaa.AAA;

// extends : 상속
public class BBB extends AAA {

	private int b;
	
	public BBB() {
		// super();  super는 부모생성자 AAA(); 를 호출하는 것을 의미한다.
		System.out.println("BBB 생성");
	}
	
	public BBB(int b) {
		super(b);    //부모생성자 AAA(abc);
		this.b = b;
		System.out.println("BBB 생성(b 받아서 생성)");
	}
	
	public BBB(int abc, int b) {
		super(abc);
		this.b = b;
		System.out.println("BBB 생성(abc,b 받아서 생성)");		
	}
	
	// getter&setter
	
	public void setB(int b) {
		this.b = b;
	}
	public int getB() {
		return b;
	}
	
	public int getSum() {
		int sum = super.getAbc() + this.getB(); //상속 받았기 때문에 getAbc()를 쓸 수 있음
				//super는 부모, this는 나를 의미. 
				//super.getABC() : 부모가 가진 getABC 다.
				//this.getB() : 내가 가진 getB 이다.
		return sum;
	}
	
	// @~ : Annotation
	@Override //부모가 갖고 있던 prn()을 다르게 쓰겠다.
	public void prn() {
		System.out.println("BB.prn()");
	}
	
}
