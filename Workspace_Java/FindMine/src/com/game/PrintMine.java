package com.game;

public class PrintMine {

	private static String[][] printArr;
	private static String[][] originalArr;
	
	static void makePrintArr(String[][] original) {
		originalArr = original;
		
		int size = originalArr.length;
		
		printArr = new String[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				printArr[i][j] = "■";
			}
		}
	}
}
