package com.bbb;

import com.aaa.AAA;

public class MTest {

	public static void main(String[] args) {
		AAA a = new AAA();
		a.prn();
		a.setAbc(100);
		System.out.println(a.getAbc());
		
		AAA aa = new AAA(200);
		System.out.println(aa.getAbc());
		
		System.out.println("----------------");
		
		BBB b = new BBB();
		b.setAbc(10);
		b.setB(20);
		System.out.println(b.getSum());
		
		BBB bb = new BBB(10);
		bb.setB(20);
		System.out.println(bb.getSum());
		
		BBB bbb = new BBB(10,20);
		System.out.println(bbb.getSum());
	}
}
