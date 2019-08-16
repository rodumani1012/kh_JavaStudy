package com.test01;

public class ArrayDouble {

	public static void main(String[] args) {
		int[][] array = {
				{12,41,36,56},{82,10,12,21},{45,26,82,34},{29,75,31,34}	
		};
		
		int sum = 0;
		int cnt = 0;
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				sum += array[i][j];
				cnt++;
			}
		}
		
		System.out.println("총 합 : " + sum);
		System.out.println("평균 : " + sum/16.0);
	}
}
