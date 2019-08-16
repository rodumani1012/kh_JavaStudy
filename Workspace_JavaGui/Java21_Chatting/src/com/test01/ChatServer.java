package com.test01;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class ChatServer {

	Vector<ServiceThread> Clients;

	public ChatServer() {
		Clients = new Vector<>(); // 유저 담는 것
	}

	public void addClient(ServiceThread st) {
		Clients.addElement(st); // 서버로부터 유저 추가
	}

	public void removeClient(ServiceThread st) {
		Clients.removeElement(st); // 서버로부터 유저 나감
	}

	public void sendMessageAll(String msg) { // 전체에게 메세지 보내기		
		try {		//메세지 내용 : "#" + UserName + "님이 들어오셨습니다."
			System.out.println(msg); // 서버 연 사람의 콘솔에 보이는 메세지

			for (int i = 0; i < Clients.size(); i++) {
				ServiceThread st = ((ServiceThread) Clients.elementAt(i));
				st.sendMessage(msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sendMessageOne(String msg, String wisper) {
		try {
			// /s 보낼사람 보낼내용
			String[] msgArr = msg.split(" "); // msgArr = [/s, 보낼사람, 보낼내용]
			String wMsg = "";
			for (int i = 2; i < msgArr.length; i++) { // msgArr.length = 3;
				wMsg += (msgArr[i] + " "); // wMsg = "보낼내용";
			}
			// [사용자이름>>보낼사람] 보낼내용
			System.out.println("[" + wisper + ">>" + msgArr[1] + "]" + wMsg);

			for (int i = 0; i < Clients.size(); i++) {
				ServiceThread one = ((ServiceThread) Clients.elementAt(i));

				if (one.getUserName().equals(msgArr[1])) {
					one.sendMessage("[" + wisper + ">>" + msgArr[1] + "]" + wMsg);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ChatServer server;
		ServerSocket serverSocket = null; // TCP 서버
		int port = 9999; // 포트 번호
		server = new ChatServer(); // 해당 포트로 서버 생성

		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			System.err.println("연결 실패");
			System.exit(1);
		}

		System.out.println("서버 \n" + serverSocket + "\n에서 연결을 기다립니다.");

		try {
			while (true) {
				Socket serviceSocket = serverSocket.accept(); // 누군가 접속이 되면
				ServiceThread thread = new ServiceThread(server, serviceSocket); // 서비스 스레드로 관리하겠다.
				thread.start();
				server.addClient(thread);
			}

		} catch (Exception e) {
			try {
				serverSocket.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
