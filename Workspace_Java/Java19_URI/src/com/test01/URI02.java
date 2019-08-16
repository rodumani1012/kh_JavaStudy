package com.test01;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URI02 {

	public static void main(String[] args) throws IOException {
		byte[] b = new byte[1];
		
		URL url = new URL("http://img.seoul.co.kr/img/upload/2016/10/18/SSI_20161018174510_V.jpg");
		
		URLConnection urlConnection = url.openConnection();
		
		DataInputStream di = new DataInputStream(urlConnection.getInputStream());
		FileOutputStream fo = new FileOutputStream("a.jpg");
		
		while(di.read(b,0,1) != -1) {
			fo.write(b,0,1);
		}
		
		fo.close();
		di.close();
		
	}
}
