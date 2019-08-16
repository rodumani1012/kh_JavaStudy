package com.test03;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class MyServer02 {

	public static void main(String[] args) throws IOException {
		// utd 방식
		
		// DatagramSocket : 8888포트로 서버를 생성한 것.
		// datagram은 패킷을 묶어서 보냄.
		// datagramsocket은 묶어진 패킷을 받는 소켓.
		DatagramSocket ds = new DatagramSocket(8888);
		System.out.println("서버입니다...");
		
		byte[] buff = new byte[1024];
		
		// DatagramPacket : 패킷으로 묶어서(19) 보내주면 패킷을 받는다.(20)
		DatagramPacket receivePacket = new DatagramPacket(buff, buff.length);
		ds.receive(receivePacket);
		
		// 받은걸 출력한다.
		System.out.println(new String(receivePacket.getData()));
		
		ds.close();
		ds.disconnect();
	}
}
