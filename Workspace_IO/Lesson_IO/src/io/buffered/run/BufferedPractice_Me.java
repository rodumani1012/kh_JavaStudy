package io.buffered.run;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedPractice_Me {

	public static void main(String[] args) {
		byte[] bt = new byte[1024];
		
		// 입력
		BufferedInputStream bis = new BufferedInputStream(System.in);

		System.out.println("값을 입력하세요 : ");

		// 출력
		try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("input.txt", true));) {
			int value = bis.read();
			System.out.println("value : " + (char) value);
			bos.write(value);
			bos.write(' ');
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}
}
