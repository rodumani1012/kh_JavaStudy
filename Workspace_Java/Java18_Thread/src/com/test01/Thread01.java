package com.test01;

public class Thread01 {

	public static void main(String[] args) {
		// main thread가 우선순위가 높다.
		System.out.println("--------------------------------");
		
		// Thread 가 아니다. 일반적인 그냥 코드.
//		MyThread m01 = new MyThread();
//		MyThread m02 = new MyThread();
//		m01.run();
//		m02.run();

		// Thread 이다.
		Thread t01 = new Thread(new MyThread()); //Runnable을 상속받은 경우 Thread 객체 안에
		Thread t02 = new Thread(new MyThread()); //Runnable 객체를 넣어줘야함.
		
		// start() -> 자동으로 run()을 호출하는 메소드
		t01.start();
		t02.start();
		
		
		
		System.out.println("--------------------------------");
		
	}
}

class MyThread implements Runnable{

	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println("i="+i);
		}
		
	}
	
	
}
