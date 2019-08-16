package com.test01;

import java.io.IOException;

public class RuntimeTest {

	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		
		try {
//			Process prc = rt.exec("notepad.exe");
			Process prc = rt.exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
			System.out.println(prc.isAlive());
			System.out.println(rt.totalMemory()); //소모하고 있는 메모리
			
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
}
