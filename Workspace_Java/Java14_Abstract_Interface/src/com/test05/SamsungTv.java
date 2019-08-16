package com.test05;

public class SamsungTv implements TV {

	private int volume;
	
	public SamsungTv() {
		System.out.println("삼성 티비가 켜졌습니다.");
	}
	
	@Override
	public int volumeUp() {
		System.out.print("볼륨업 ");
		volume += 3;
		return volume;
	}

	@Override
	public int volumeDown() {
		System.out.print("볼륨다운 ");
		volume -= 3;
		return volume;
	}

}
