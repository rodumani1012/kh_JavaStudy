package com.car;

public class MTest {

	public static void main(String[] args) {
		
		Car c1 = new SportsCar("빨간");
		c1.accelPedal();
		c1.accelPedal();
		System.out.println(c1); // 객체를 출력하면 toString() 메소드가 내부적으로 실행됨.
		c1.breakPedal();
		c1.breakPedal();
		c1.breakPedal();
		System.out.println(c1);
		
		Car c2 = new SUV("검은");
		c2.accelPedal();
		c2.accelPedal();
		System.out.println(c2);
		c2.breakPedal();
		c2.breakPedal();
		c2.breakPedal();
		System.out.println(c2);
		
		/*
		 * Car 클래스를 상속하는 Truck 클래스를 만들자.
		 * 기본 생성자
		 * 파라미터 1개짜리 생성자 (String)
		 * 
		 * accelPedal()
		 * breakPedal()
		 * toString()
		 * 3개 만들고
		 * 
		 * 속도가 '천천히' 로 바꿔주고
		 * 속도 증감을 10으로 설정.
		 */
	}
}
