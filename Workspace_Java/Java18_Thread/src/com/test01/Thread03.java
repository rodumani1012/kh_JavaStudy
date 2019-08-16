package com.test01;

class MyThread03 extends Thread{
	// thread 이름을 지정해보자
	public MyThread03(String name) {
		super(name);
	}
	@Override
	public void run() {
		for(int i = 0; i<1000; i++) {
			System.out.println(this.getName() + " : " + i);
		}
		System.out.println(this.getName() + " 끝!!!!!!");
	}
}

public class Thread03 {

	public static void main(String[] args) {
		
		MyThread03 cat = new MyThread03("야옹");
		MyThread03 dog = new MyThread03("멍멍");
		
		// java의 thread scheduling은
		// 우선순위(priority) 와
		// 순환 할당(round-robin) 방식을 사용한다.
		cat.setPriority(10);
		dog.setPriority(Thread.MIN_PRIORITY);
		// 우선순위가 10 : 1로 야옹이가 높아 야옹이가 먼저 끝날 확률이 더 높다. (야옹이가 늦게 끝날 경우도 있긴 함)
		
		cat.start();
		dog.start();
		
		System.out.println(cat.getPriority() + " : " + dog.getPriority());
	}
}
