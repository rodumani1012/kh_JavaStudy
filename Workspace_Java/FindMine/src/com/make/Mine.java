package com.make;

public class Mine {
	
	private int size;
	private String[][] arr;
	
	public Mine() { // 값이 없으면 기본적으로 10 * 10 사이즈 형태의 맵
		this.size = 10;
	}
	public Mine(int size) { // 값을 지정하면 size * size 형태의 맵을 만듦
		this.size = size;
	}
	
	public String[][] make() {
		arr = new String[size][size];
		
		// 0으로 초기화 시켜주는 애
		fillTheZero();
		
		// 랜덤으로 폭탄 설치
		randomMine();
		
		// 주변의 폭탄 카운트
		cntMineArea();
		
		prnTest();
		
		return arr;
	}
	private void cntMineArea() {
		for(int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if(!arr[i][j].equals("*")) {
					arr[i][j] = String.valueOf(cntMineXY(i,j));
				}
			}
		}
	}
	private int cntMineXY(int x, int y) {
		int cnt = 0;
		
		for (int i = x-1; i <= x+1; i++) {
			for (int j = y-1; j <= y+1; j++) {
				if(i < 0 || j < 0) {
					continue;
				}
				if(i > arr.length-1 || j > arr.length-1) {
					continue;
				}
				if(arr[i][j].equals("*")) {
					cnt++;
				}
			}
		}
		
		return cnt;
	}
	private void randomMine() {
		int cnt = size;
		
		while(cnt != 0) {
			int ranX = (int)(Math.random()*size);
			int ranY = (int)(Math.random()*size);
			
			if (!arr[ranX][ranY].equals("*")) {
				arr[ranX][ranY] = "*";
				cnt--;
			}
		}
	}
	private void fillTheZero() {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				arr[i][j] = "0"; 
			}
		}
	}
	
	private void prnTest() {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
