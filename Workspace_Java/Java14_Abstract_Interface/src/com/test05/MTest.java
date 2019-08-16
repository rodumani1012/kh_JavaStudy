package com.test05;

public class MTest {

	public static void main(String[] args) {
		
		LgTv lg = new LgTv();
		System.out.println(lg.volumeUp());
		System.out.println(lg.volumeUp());
		System.out.println(lg.volumeDown());
		System.out.println(lg.volumeDown());
		System.out.println(lg.volumeDown());
		
		SamsungTv sm = new SamsungTv();
		System.out.println(sm.volumeUp());
		System.out.println(sm.volumeDown());
	}
}
