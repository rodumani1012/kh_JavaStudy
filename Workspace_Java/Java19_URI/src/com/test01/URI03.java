package com.test01;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URI03 {

	public static void main(String[] args) throws MalformedURLException, IOException {
		
		URLConnection urlc = new URL("https://www.naver.com").openConnection();
		
		BufferedInputStream buff = new BufferedInputStream(urlc.getInputStream());
		
		int byteRead;
		while((byteRead=buff.read()) != -1) {
			System.out.print((char)byteRead);
		}
		
		buff.close();
		
	}
}
