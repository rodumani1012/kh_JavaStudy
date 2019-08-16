package com.car;

public class SUV extends Car {

	public SUV() {
		System.out.println("SUV 생성");
	}
	public SUV(String color) {
		super(color,0);
		System.out.println(color + "색 SUV 생성");
	}
	
	@Override
	public void accelPedal() {
		// 속도를 20씩 증가 시키자.
		// speed = speed + 20;
		// speed라는 값을 가져와서 => getSpeed();
		// 20을 더한다.
		// speed에 대입한다.  => setSpeed();
		setSpeed(getSpeed() + 20);
		
		// "속도가 적당히 증가합니다." 출력
		System.out.println("속도가 적당히 증가합니다.");
	}
	@Override
	public void breakPedal() {
		// 속도를 20씩 감소 시키자.
		int tmp = getSpeed() - 20;
		setSpeed(tmp);
		// "속도가 적당히 감소합니다." 출력
		// 만일 속도가 0이면 "멈췄습니다." 를 출력.
		if(getSpeed() >=0) {
			System.out.println("속도가 적당히 감소합니다.");			
		} else {
			System.out.println("멈췄습니다.");
			setSpeed(0);
		}		
	}
	
	@Override
	public String toString() {
		return "SUV의 현재 속도는 " + getSpeed() + " 입니다.";
	}
}
