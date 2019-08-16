package com.test01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IOTest03 {

	// 내부에서 예외처리하고, try with resource문을 사용해보자
	public static void main(String[] args) {
		File fi = new File("a.txt");

		MyOutput(fi);
		MyInput(fi);
	}

	private static void MyInput(File fi) {
		
		// try with resource 문 
		// try(에러가 날 수 있는 명령문들) {에러가 안났을때 할 명령문들}
		try(FileReader fr = new FileReader(fi)){ 
			
			int ch;
			while((ch=fr.read()) != -1) {
				System.out.print((char)ch);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void MyOutput(File fi) {
		FileWriter fw = null;

		try {								//false는 처음부터 다시 쓰기
			fw = new FileWriter(fi, true); // true는 마지막부터 이어쓰기
			fw.write("연습중입니다.\n");
			fw.append("abc\n");

		} catch (IOException e) {
			e.printStackTrace();

		} finally {

			try {
				fw.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}
}
