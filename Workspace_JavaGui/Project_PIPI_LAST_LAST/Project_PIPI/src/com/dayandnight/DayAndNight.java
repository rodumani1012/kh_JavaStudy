package com.dayandnight;

import java.util.Timer;
import java.util.TimerTask;

import com.EGGDisplay.Main;

//밤낮
public class DayAndNight {

	/*
	 * 시간 낮1분, 밤1분 낮(일수++)
	 */


	public DayAndNight() {
		go();
	}

	public void go() {
		AllDay all = new AllDay();// 객체 선언
		Night_Stamina N_S = new Night_Stamina();
		
		Timer timer = new Timer();// 객체 선언
		
		// timer.scheduleAtFixedRate(all, 60000, 60000);// all(밤 낮)을 1(60000)분에 1번 실행
		// timer.scheduleAtFixedRate(N_S, 5000, 5000);// N_S(체력-)를 5(5000)초에 1번씩 실행
		timer.scheduleAtFixedRate(all, 2,1000);
		timer.scheduleAtFixedRate(N_S, 1000, 5000);

		try {
			Thread.sleep(600000);
			// 60분(600000) 동안 Thread실행
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			timer.cancel();
		}

		if (N_S.MYSTAMINA == 0 || N_S.MYSTAMINA < 0) {
			Thread.interrupted();
		}

	}

}



class Night_Stamina extends TimerTask {
	Main mmain = new Main();

	// 밤일 때 안자면 체력(5초당 -1씩)

	public static String SlEEP = "N";// 잠을 자지 않는 상태
	public static int MYSTAMINA = 10;// 체력

	@Override
	public void run() {

		if (MYSTAMINA > 0) {// 체력이 0보타 클 때
			AllDay all = new AllDay();// 객체 생성
			if (all.MYALLDAY.equals("N")) {// 밤이라면
				if (SlEEP.equals("N")) {// 잠을 자지 않는 상태라면
					MYSTAMINA = MYSTAMINA - 1;// 체력을 -1해준다.
					System.out.println("HP : " + MYSTAMINA);
				}
			}
		} else if (MYSTAMINA == 0 || MYSTAMINA < 0) {// 체력이 0이거나 그것 보다 작다면
			try {
				while (!Thread.currentThread().isInterrupted()) {
					// 실행문
					Thread.interrupted();// 스레드 중지
				}
				Thread.sleep(0);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
