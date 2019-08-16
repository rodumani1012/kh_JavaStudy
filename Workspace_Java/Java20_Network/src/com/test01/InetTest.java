package com.test01;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetTest {

	public static void main(String[] args) throws UnknownHostException {
		InetAddress addr = InetAddress.getLocalHost();
		System.out.println(addr);
		System.out.println("localhost : " + addr.getHostAddress());
		System.out.println("host name : " + addr.getHostName() + "\n");
		
		InetAddress[] naver = InetAddress.getAllByName("www.naver.com");
		for(InetAddress ip : naver) {
			System.out.println(ip.getHostName() + " : " + ip.getHostAddress());
		}
		
	}
}
