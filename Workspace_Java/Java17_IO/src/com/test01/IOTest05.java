package com.test01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOTest05 {

	public static void main(String[] args) throws IOException {
		File fi = new File("b.txt");
		// b.txt에 A ~ Z 까지 입력하고,
		// b.txt에 있는 내용을 console로 출력하자.

		numOutput(fi);
		numInput(fi);
	}

	private static void numOutput(File fi) throws IOException {
		FileOutputStream fout = new FileOutputStream(fi);

		for (int i = 65; i < 91; i++) {
			fout.write(i);
		}
		fout.close();
	}

	private static void numInput(File fi) throws IOException {
			FileInputStream fin = new FileInputStream(fi);

			// output : 입력(저장하기), input : 출력(읽어오기)
			// 내가 주면 output 내가 받으면 input
			// input : 다른애에서 나한테 읽어온다. output : 내가 다른애한테 보낸다.
			int res = 0;
			
			while((res=fin.read()) != -1) {
				System.out.print((char)res);
			}
			fin.close();
	}
}
