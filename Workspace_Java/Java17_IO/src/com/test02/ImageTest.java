package com.test02;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageTest {

	public static void main(String[] args) throws IOException {
		// XX.jpg(이미지)를 받아서
		// 다른 이름(out)으로 저장해보자
		String fileName = "Desert.jpg";

		/*
		 * FileInputStream fi = new FileInputStream(fileName); 
		 * BufferedInputStream bi = new BufferedInputStream(fi);
		 */
		// 15~16라인을 한줄로 표현
		BufferedInputStream bi = new BufferedInputStream(new FileInputStream(fileName));

		FileOutputStream fo = new FileOutputStream(new File("out.jpg"));

		int i = 0;
		while ((i = bi.read()) != -1) {
			fo.write(i);
		}
		
		// 가장 마지막에 연 것을 먼저 닫아줘야함.
		fo.close();
		bi.close();
		
	}
}
