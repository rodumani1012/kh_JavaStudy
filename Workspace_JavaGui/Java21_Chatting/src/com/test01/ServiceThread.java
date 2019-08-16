package com.test01;

import java.io.*;
import java.net.Socket;

public class ServiceThread extends Thread {

	private ChatServer server;
	private Socket socket;
	
	private String UserName;
	private PrintWriter out;
	private BufferedReader in;
	
	public String getUserName() {
		return UserName;
	}
	
	public ServiceThread(ChatServer server, Socket socket){ // 서버랑 소켓 받아서 연결
		this.server = server;
		this.socket = socket;
	}
	
	public void sendMessage(String msg) throws IOException{
		if(out != null){
			out.println(msg); // 서버 -> 클라이언트
		}
	}

	public void run() {
		try{
			
			System.out.println("클라이언트\n" + socket + "\n에서 접속하였습니다.");
			
			out = new PrintWriter(socket.getOutputStream(),true); // 서버 -> 클라이언트(클라이언트한테)
			in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 클라이언트에서 들어온 데이터  
			
			out.println();
			out.println("UserName : "); // 스레드에서 클라이언트로 
			UserName = in.readLine();
			sendMessage(UserName);
			server.sendMessageAll("#" + UserName + "님이 들어오셨습니다.");
			String inputLine;

			while((inputLine = in.readLine()) != null){

				if(inputLine.contains("/s")) {
					server.sendMessageOne(inputLine,UserName);
				}else {
					server.sendMessageAll("[" + UserName +"]" + inputLine);
				}
				
			}
			out.close();
			in.close();
			socket.close();
		}catch(IOException e){
			server.removeClient(this);
			server.sendMessageAll("#" + UserName + "님이 나가셨습니다.");
			System.out.println("클라이언트 \n" + socket + "\n에서 접속이 끊겼습니다...");
		}
	}
}

