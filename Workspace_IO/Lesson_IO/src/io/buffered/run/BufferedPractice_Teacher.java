package io.buffered.run;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedPractice_Teacher {

	public static void main(String[] args) {
		byte[] bt = new byte[1024];

		// 입력
		BufferedInputStream bis = null;
		bis = new BufferedInputStream(System.in);
		
		BufferedOutputStream bos = null;

		System.out.println("입력한 것을 파일과 모니터에 출력");
		System.out.println("================================");
		
		System.out.println("입력 : ");
		try {
			bis.read(bt); // byte배열 bt에 값을 저장
			
			// 출력
			bos = new BufferedOutputStream(new FileOutputStream("input2.txt"));
			bos.write(bt);
			
			System.out.println("출력 : ");
			System.out.println(new String(bt)); // byte배열에 있는 값을 String으로 형변환해서 출력
			
		} catch (IOException e2) {
			e2.printStackTrace();
		} finally {
			try {
				bos.close();
				bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
