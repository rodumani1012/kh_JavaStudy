package io.file.fileChar.model.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCharTest {

	// 문자기반스트림
	// 바이트기반스트림 -> 1byte
	// 문자기반스트림 -> 2byte
	
	// 종류 : FileReader/FileWriter
	
	// write() 5가지 -> write(int), write(char[]), write(char[], off, len),
	// write(String), write(String, off, len)
	
	public void fileSave() {
		FileWriter fw = null;
		
		try {
			fw = new FileWriter("sample.txt");
			
			//write(String)
			fw.write("입출력 기술향상");
			
			//write(char[])
			char[] carr= new char[] {'a', 'b', 'c'};
			fw.write(carr);
			
			//write(String, off, len)
			fw.write("123456", 2, 3); //2번째부터 3개
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void fileRead() {
		FileReader fr = null;
		
		try {
			fr = new FileReader("sample.txt");
			
			int temp;
			while((temp=fr.read()) != -1) {
				System.out.print((char)temp);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
