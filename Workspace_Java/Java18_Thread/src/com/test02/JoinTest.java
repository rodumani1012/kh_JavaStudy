package com.test02;

class MyCalc extends Thread {
	private int start;
	private int end;
	int sum;

	public MyCalc(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public void run() {
		sum = 0;

		for (int i = start; i <= end; i++) {
			sum += i;
			System.out.println("current thread : " + currentThread().getName());
		}
	}
}

public class JoinTest {

	public static void main(String[] args) throws InterruptedException {
		
		MyCalc thread01 = new MyCalc(1, 5);
		MyCalc thread02 = new MyCalc(6, 10);
		
		thread01.start();
		thread02.start();
		
		thread01.join(); //thread01이 끝날때까지 다른 애들 멈춰라.
//		thread02.join(); //thread02가 끝날때까지 다른 애들 멈춰라.
		
		System.out.println("thread01 : " + thread01.sum); //1~5 까지의 합
		System.out.println("thread02 : " + thread02.sum); //6~10 까지의 합
		
		System.out.println("total : " + (thread01.sum + thread02.sum)); //그 둘의 총합
											//32,34라인에 join()이 없을 경우
											//스레드이므로 55가 안나오는 경우도 있음.
	}
}
