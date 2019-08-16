package com.test02;

public class SleepTest {

	public static void main(String[] args) {
		
		while(true) {
			for(int i=1; i< 11; i++) {
				
				try {
					Thread.sleep(500); // sleep() : 내가 원하는 시간만큼 스레드를 멈춘다.
									   //0.5초 후
					System.out.print("♥ ");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println();
		}
	}
}
