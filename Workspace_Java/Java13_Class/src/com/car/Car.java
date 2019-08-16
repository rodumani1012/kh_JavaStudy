package com.car;

public class Car {

	private String color;
	private int speed;
	
	// 기본 생성자
	public Car() {
		
	}
	
	// 파라미터 2개짜리 생성자 (String, int)
	public Car(String color, int speed) {
		
	}

	// field 각각 getter & setter	
	public String getColor() {
		return color;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void accelPedal() {
		System.out.println("속도가 올라갑니다.");
		speed = speed + 10;
	}
	
	public void breakPedal() {
		System.out.println("속도가 줄어듭니다.");
		speed = speed - 10;
	}
	
	@Override
	public String toString() {
		return "현재 속도는 " + speed + " 입니다.";
	}
}
