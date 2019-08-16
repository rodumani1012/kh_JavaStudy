package com.allTime;

import java.util.Timer;
import java.util.TimerTask;

public class AllTime {
	// 포만 10초당--20
	// 청결 10초당 -10

	public static void main(String[] args) {

		ATime atime = new ATime();// 객체 생성

		Timer timer = new Timer();

		timer.scheduleAtFixedRate(atime, 10000, 10000);// 10초에 1번 ATime실행

		try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			timer.cancel();
		}
	}

}

class ATime extends TimerTask {
	// 포만 10초당--20
	// 청결 10초당 -10
	public static int MYFULL = 100;// 포만
	public static int MYCLEAN = 100;// 청결

	@Override
	public void run() {

		MYFULL = MYFULL - 20;// 포만 -20
		MYCLEAN = MYCLEAN - 10;// 청결-10
		System.out.println("포만 : " + MYFULL);
		System.out.println("청결 : " + MYCLEAN);

	}

}
