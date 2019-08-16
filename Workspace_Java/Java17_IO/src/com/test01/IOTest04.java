package com.test01;

import java.io.File;

public class IOTest04 {

	public static void main(String[] args) {
		File fi = new File("c:\\");
		
//		printFile01(fi); //c드라이브에 무슨 파일들이 있는지 출력해봤음.
		printFile02(fi);
	}

	private static void printFile02(File fi) {
		int dirCnt = 0;
		int fileCnt = 0;
		
		for(File list : fi.listFiles()) {
			if(list.isFile()) {
				System.out.println("file : " + list.getName());
				fileCnt++;
			} else if (list.isDirectory()) {
				System.out.println("dir : " + list.getName());
				dirCnt++;
			}
		}
		System.out.println("폴더의 갯수 : " + dirCnt);
		System.out.println("파일의 갯수 : " + fileCnt);

	}

	private static void printFile01(File fi) {
		for(String list : fi.list()) {
			System.out.println(list);
		}
		
	}
}
