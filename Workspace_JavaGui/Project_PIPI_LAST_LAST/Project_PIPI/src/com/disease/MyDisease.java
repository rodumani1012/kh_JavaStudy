package com.disease;

//import java.awt.Button;
import java.util.Timer;
import java.util.TimerTask;

//질병 Y일때
public class MyDisease {
	//public static int res = 60000;

	/*
	 * 질병 Y 약먹어야 진행 가능 (체력-- 애정--) (5초당 3씩)
	 */
	public static void main(String[] args) {
		
		Disease disease = new Disease();// 객체 선언
		Timer timer = new Timer();// 객체 선언
		

		// disease를 5초마다 disease실행
		timer.scheduleAtFixedRate(disease, 5000, 5000);
		
		/*
		 * if(disease.MYHEART == 0 || disease.MYSTAMINA == 0 ) { try { Thread.sleep(0);
		 * } catch (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } }
		 */
		

		try {
			while(! Thread.currentThread().isInterrupted()) {
			    // 종료
			   Thread.interrupted();

			}
			Thread.sleep(200000);
			 
			// 60분 동안 Thread실행
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		timer.cancel();

	}

}
class Disease extends TimerTask {

	public static String MYDISEASE = "Y";
	public static int MYSTAMINA = 10;// 체력
	public static int MYHEART = 10;// 애정
	int cnt=0;
	//public static Button btn01,btn02,btn03,btn04,btn05;

	@Override
	public void run() {

		if ((MYHEART > 3 && MYHEART < 100) && (MYSTAMINA > 3 && MYSTAMINA < 100)) {
			if (MYDISEASE.equals("Y")) {
				MYSTAMINA = MYSTAMINA - 3;
				MYHEART = MYHEART - 3;
				System.out.println("애정 : " + MYHEART);
				System.out.println("체력 : " + MYSTAMINA);
				/*
				 * btn01.setEnabled(false); btn02.setEnabled(false); btn03.setEnabled(false);
				 * btn04.setEnabled(false); btn05.setEnabled(false);
				 */
			}else if(MYDISEASE.equals("N")) {
				/*
				 * btn01.setEnabled(true); btn02.setEnabled(true); btn03.setEnabled(true);
				 * btn04.setEnabled(true); btn05.setEnabled(true);
				 */
			}

		}else if(MYHEART == 0 ||MYSTAMINA == 0 ) {
			try {
				while(! Thread.currentThread().isInterrupted()) {
				    // 종료
				   Thread.interrupted();
				}
				Thread.sleep(0);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		else {
			MYHEART = 0;
			MYSTAMINA = 0;
			cnt++;
			System.out.println("애정1 : " + MYHEART);
			System.out.println("체력2 : " + MYSTAMINA);
			System.out.println(cnt);
			
			
		}

	}

}
