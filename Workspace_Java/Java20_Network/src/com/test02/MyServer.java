package com.test02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer  {
// tcp 방식
	public static void main(String[] args) {
		
		// 서버 생성
		ServerSocket serverSocket = null; // 서버를 만들어서 소켓을 연결시켜주는 애
		
		// 서버에 접속한 클라이언트(소켓)
		Socket serviceSocket = null;
		
		// 출력 객체(서버에서 클라이언트로 출력)
		PrintWriter out = null;
		
		// 클라이언트로부터 읽어드린 데이터를 버퍼에 담을 객체
		BufferedReader in = null;
		
		try {
			serverSocket = new ServerSocket(9999); //아무 숫자나 넣은 것
			// 8080에서 앞에 80은 http 통신 수단용으로 쓰자는 암묵적인 것.
			// 서버 소켓을 열어둠
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		while(true) {
			System.out.println("client를 기다립니다...");
			
			try {
				
				// 서버에 연결된 client socket
				serviceSocket = serverSocket.accept();
				// accept() : 해당 서버의 소켓으로 누군가 들어왔다.
				// 연결된 애를 담아두겠다.
				System.out.println("client가 접속했습니다...");
				
				// client에게 받은 데이터를 line 단위로 읽자.
				in = new BufferedReader(new InputStreamReader(serviceSocket.getInputStream()));
				// 클라이언트가 보내준 데이터(inputStream)를 InputStreamReader로 읽어오는데
				// 하나하나 읽어오는 것보다 뭉탱이로 읽는게 좋으니까 BufferedReader로 묶어서 읽어온다.
				// 접속한 클라이언트가 out한것을 보내주고 있다.
				
				// client에게 보내주겠다.
				out = new PrintWriter(serviceSocket.getOutputStream(), true);
				// 보낸것을 받는다.
				
				String inputLine;
				while((inputLine = in.readLine()) != null) {
						// 한줄씩 읽어서(in.readLine()) 문자열(inputLine)에 집어넣고 null이 아닐때까지 읽는다.
					System.out.println("client : " + inputLine); // 읽어온거 출력하고
					out.println("★" + inputLine); // client에게 보내줌
				}
				
				out.close();
				in.close();
				serviceSocket.close();
				serverSocket.close();
				System.out.println("서버 종료...");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
