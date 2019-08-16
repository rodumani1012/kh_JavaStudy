package com.test01;

import java.io.File;
import java.io.IOException;

public class IOTest01 {

	public static void main(String[] args) {

		// 해당 경로에 fi(file)을 생성하자.
		File fi = new File("c:\\TEST_IO"); // c:/TEST_IO 로 써도 됨

		if (fi.exists()) { // 해당 폴더에 해당 파일이 존재 하는지 true, false 반환
			System.out.println("exists !!");
		} else {
			System.out.println("new !!");
			fi.mkdir(); // 설정한 이름으로 폴더가 생성된다. make directory(mkdir)
		}

		File fic01 = new File(fi, "AA"); // TEST_IO 폴더 안에 AA폴더 만들기
		fic01.mkdir();

		File fic02 = new File("c:/TEST_IO", "BB"); // TEST_IO 폴더 안에 BB폴더 만들기
		fic02.mkdir();

		File txtFile = new File(fic02, "a.txt"); // BB 폴더 안에 텍스트 파일 만들기

//		txtFile.createNewFile(); //오류 발생. 빨간 줄 뜨면서 예외처리 해달라고 에러 뜸.
		
		// checked exception      컴파일 시 Unhandled exception type IOException 이라고 뜨는 에러
		try {
			txtFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
