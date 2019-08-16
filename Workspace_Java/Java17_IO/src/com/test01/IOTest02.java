package com.test01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IOTest02 {

	//throws 를 활용하여 예외처리 해보자.
	public static void main(String[] agrs) {
		File fi = new File("a.txt"); //경로 미지정하면 최상위 폴더에 자동 생성됨.

//		MyOutput(fi); //오류발생. MyOutput메소드에서 던져준(위임시킨) 예외를 처리하기 위해 try catch 해줌.
		
		try {
			MyOutput(fi);
			MyInput(fi);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// throws : 해당 메소드를 호출하고 있는 애(main메소드)에게 위임시킴
	private static void MyOutput(File fi) throws IOException {
		FileWriter fw = new FileWriter(fi, false); //false는 처음부터 다시 쓰기
													//true는 마지막부터 이어쓰기
		fw.write("연습중입니다.\n");
		fw.append("abc\n");

		fw.close(); // 내가 만든 FileWriter 객체를 종료해주는 것.(안하면 메모리에 계속 올라가있음)

	}

	private static void MyInput(File fi) throws IOException {
		// input : 읽어오기.  output : 저장하기
		FileReader fr = new FileReader(fi);
		// FileReader는 FileInputStream의 하위 클래스
		
		int ch;
		// file 내용의 처음부터 끝까지
		// 한 글자씩 읽어서 출력한다.
		while((ch=fr.read()) != -1) { //한 글자씩 숫자로 바꿔서 읽어옴. -1은 파일내용의 끝을 의미.
			System.out.print((char)ch); //숫자로 읽어와진 ch를 (char)로 캐스팅 해줌.
		}
		
		fr.close();
		
	}
}
