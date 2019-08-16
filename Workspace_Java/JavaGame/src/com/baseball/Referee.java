package com.baseball;

public class Referee {

	int[] output;
	
	public int[] isStrike(int[] goal, int[] input) {
		// 0번지 stirke;
		// 1번지 ball;
		// 2번지 out;
		
		output = new int[3];
		
		int strikeCnt = 0;
		int ballCnt = 0;
		
		for(int i = 0 ; i < goal.length ; i++) {
			for(int j = 0 ; j < input.length ; j++) {
				if(goal[i] == input[j]) {
					if(i==j) {
						strikeCnt++;
					}else {
						ballCnt++;
					}
				}
			}
		}
		
		if((strikeCnt + ballCnt) == 0) {
			output[2] = 1;
		}else {
			output[0] = strikeCnt;
			output[1] = ballCnt;
		}
		
		return output;
	}
}
