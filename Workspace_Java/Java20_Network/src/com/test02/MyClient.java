package com.test02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyClient implements Runnable {
	// tcp 방식
	
	@Override
	public void run() {
		try {
			// 소켓 생성
			Socket clientSocket;
			
			// 서버에게 보내줄 객체
			PrintWriter out = null;
			
			// 서버에서 받을 객체
			BufferedReader in = null;
			
			// 콘솔에서 받을 객체. standardIn
			BufferedReader stdIn = null;
			
			System.out.println("server에 접속합니다...");
			
			// ip주소랑, 포트번호를 가지고 socket 생성
			clientSocket = new Socket("localhost", 9999);
			
			// output : 입력(저장하기), input : 출력(읽어오기)
			// 내가 주면 output 내가 받으면 input
			// input : 다른애에서 나한테 읽어온다. output : 내가 다른애한테 보낸다.
			
			// 서버에게 데이터 보내기 위한 객체. true는 값을 자동으로 비워줌
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			// out : 서버에 저장해주는 것
			
			// 서버에서 받아온 데이터를 라인 단위로 읽고 있다.???
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			// in : 서버에서 받아오는 것
			
			// 콘솔에서 입력된 데이터를 라인 단위로 읽고 있다.
			stdIn = new BufferedReader(new InputStreamReader(System.in));
			// stdIn : 콘솔에서 입력한 값 받아서 뿌려주는 애
			
			String inputLine;
			while((inputLine = stdIn.readLine()) != null) {
					// stdIn.readLine() 콘솔에서 한 줄 읽어오겠다.
				out.println(inputLine);
				// 서버에 보내서
				System.out.println("server return : " + in.readLine());
										// 서버로부터 다시 받아오고 있다.
			}
			
			stdIn.close();
			in.close();
			out.close();
			clientSocket.close();
			System.out.println("소켓을 닫았다...");
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		Thread t1 = new Thread(new MyClient());
		t1.start();
	}
}
