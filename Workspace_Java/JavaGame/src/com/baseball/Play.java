package com.baseball;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * 야구게임
 * 1. 숫자 3개 입력 (ex. 3 4 6)
 * 2. 내부적으로 만들어진 목표 숫자 (ex.489)와 비교
 * 3. 같은 자리에 같은 값 = strike
 *    자리는 다르지만 같은 값 = ball
 *    같은 값이 없으면 = out
 *    (ex. 1 strike 0 ball)
 * 4. 총 10번 안에 목표 숫자와 입력받은 숫자가 완전히 같으면 승리
 */
public class Play extends Print{

	static int[] goal;
	static Scanner sc = new Scanner(System.in);
	
	static int stage = 10;
	
	public static void main(String[] args) {
		Referee referee = new Referee();
		User user = new User();
		
		int[] strike;
		
		try {
			while(true) {
				System.out.println(START);
				goal = new Ball().getGoal();
				System.out.println("목표 숫자 : " + Arrays.toString(goal));
				
				do {
					System.out.println("["+(10-stage+1)+"]"+ING);
					
					int[] input = user.input();
					
					strike = referee.isStrike(goal, input);
					strikePrn(strike);
					
					if(strike[0] == 3) {
						System.out.println(WIN);
						break;
					}
					
					stage--;
					
				}while(stage > 0);
				
				if(stage == 0) {
					System.out.println(LOSE_PRE+Arrays.toString(goal)+LOSE_POST);
				}
				System.out.println(END);
				String stop = sc.next();
				if(stop.toLowerCase().equals("n")) {
					break;
				}
			}
			
			System.out.println(BYE);
			
		} catch (Exception e) {
			System.out.println(ERROR);
		} finally {
			sc.close();
		}
	}
}














