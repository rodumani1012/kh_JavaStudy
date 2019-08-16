package com.car;

public class SportsCar extends Car{
	
	public SportsCar() {
		System.out.println("스포츠카 생성");
	}
	public SportsCar(String color) {
		super(color, 0);
		System.out.println(color + "색 스포츠카 생성");
	}
	
	@Override
	public void accelPedal() {
		// 속도를 30씩 증가 시키자.
		setSpeed(getSpeed() + 30);
		// "속도가 빨리 증가합니다." 출력		
		System.out.println("속도가 빨리 증가합니다.");
		
	}
	@Override
	public void breakPedal() {
		// 속도를 30씩 감소 시키자.
		int tmp = getSpeed() - 30;
		setSpeed(tmp);
		// "속도가 빨리 감소합니다." 출력
		// 만일 속도가 0이면 "멈췄습니다." 를 출력.
		if(getSpeed() >=0) {
			System.out.println("속도가 빨리 감소합니다.");			
		} else {
			System.out.println("멈췄습니다.");
			setSpeed(0);
		}						
	}
	
	@Override
	public String toString() {
		return "스포츠카의 현재 속도는 " + getSpeed() + " 입니다.";
	}
}
