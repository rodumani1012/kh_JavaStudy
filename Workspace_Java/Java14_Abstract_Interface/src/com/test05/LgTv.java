package com.test05;

public class LgTv implements TV {

	private int volume;
	
	public LgTv() {
		System.out.println("엘지 티비가 켜졌습니다.");
	}
	
	@Override
	public int volumeUp() {
		System.out.print("볼륨업 ");
		volume += 1;
		return volume;
	}

	@Override
	public int volumeDown() {
		System.out.print("볼륨다운 ");
		volume -= 1;
		return volume;
	}

}
