package com.test03;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class MyClient02 {

	public static void main(String[] args) throws IOException {
		
		// 클라이언트는 포트 번호 안넣었음!
		// Socket 생성
		DatagramSocket ds = new DatagramSocket();
		System.out.println("클라이언트 입니다.");
		
		byte[] buff = "연습입니다.".getBytes();
		
		// Packet으로 감싸서, server에 보낼 준비
		DatagramPacket sendPacket = new DatagramPacket(buff, buff.length, 
						InetAddress.getByName("localhost"),8888);
		
		// 해당 socket으로 보낸다.
		ds.send(sendPacket);
		
		ds.close();
		ds.disconnect();
	}
}
