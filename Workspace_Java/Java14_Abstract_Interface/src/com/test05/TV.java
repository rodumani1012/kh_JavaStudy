package com.test05;

public interface TV {
	
	
	int volumeUp();
	int volumeDown();
	
	// TV 인터페이스를 상속받은
	// LgTv 와 SamsungTv class 를 만들자.
	// LgTv의 up/down은 +1/-1
	// SamsungTv의 up/down은 +3/-3
	// 생성자가 호출될 때 "삼성 티비가 켜졌습니다."
	// "엘지 티비가 켜졌습니다."
}
