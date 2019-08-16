package com.project;

import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.blackjack.BlackjackMethod;
import com.my.dao.ProjectDao;
import com.my.dto.ProjectDto;
import com.seoda.SeodaMethod;

public class Server {

	ProjectDao projectdao = new ProjectDao();
	ProjectDto projectdto = new ProjectDto();

	// 각 Clients의 serviceThread가 보관되어 관리 당함
	List<ServiceThread> Clients;

	// 블랙잭 메소드
	BlackjackMethod BJMethod = new BlackjackMethod();

	// 섯다 메소드
	SeodaMethod seodaMethod = new SeodaMethod();

	// 기본 생성자(클라이언트를 담음 리스트생성)
	public Server() {
		Clients = new ArrayList<>();
	}

	// Clients 추가
	public void addClient(ServiceThread st) {
		synchronized (Clients) {
			Clients.add(st);
		}
	}

	// Clients 삭제
	public synchronized void removeClient(ServiceThread st) {
		Clients.remove(st);

		// 어느 서버에 있건 같으면 remove 해줌, 그리고 해당 게임이 원하는 메소드를 진행함
		if (BJMethod.removeClient(st)) {
			BJMethod.otherUser("name");
			BJMethod.turn();
			BJMethod.ready();
		} else if (seodaMethod.removeClient(st)) {
			seodaMethod.otherUser("name");
			seodaMethod.ready();
		}

	}

	// 회원가입(server -> dao)
	public synchronized boolean newId(String msg) {
		// db와 연동해서 성공하면 0 이상 값 반환하여 true를 serviceThread에 전달
		if (projectdao.insert(msg) > 0) {
			System.out.println("회원가입 성공");
			return true;
		} else {
			return false;
		}
	}

	// 로그인(server -> dao)
	public synchronized ProjectDto login(String msg) {
		// db와 연동해서 dto에 dao에서 넘겨준 dto를 저장
		projectdto = projectdao.login(msg);

		// 성공하였으면 dto는 null이 아니기 때문에 dto를 serviceThread에 전달
		if (projectdto != null) {
			return projectdto;
		} else {
			return null;
		}
	}

	// 각 게임 Clients로 유저 넘김
	// 각각의 유저가 원하는 게임을 들어가면 그 게임 인원수를 증가시킴
	public void deliverUser(String game, String name) {
		synchronized (Clients) {
			for (int i = 0; i < Clients.size(); i++) {
				ServiceThread st = Clients.get(i);
				System.out.println(st.getDto().getName());
				if (st.getDto().getName().equals(name)) {
					switch (game) {
					case "blackjack":
						BJMethod.addBlackjackClients(st);
						break;
					case "seoda":
						seodaMethod.addSeodaClients(st);
						break;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Server server;
		ServerSocket serverSocket = null; // 서버 소켓 호출
		int port = 5555;
		server = new Server(); // 기본생성자 생성

		try {
			serverSocket = new ServerSocket(port); // 서버 소켓을 포트번호를 받아 생성
		} catch (IOException e) {
			System.err.println("연결 실패");
			System.exit(1);
		}

		System.out.println("서버 \n" + serverSocket + "\n에서 연결을 기다립니다.");

		while (true) {
			try {
				// Client의 소켓을 serviceSocket에 담고
				Socket serviceSocket = serverSocket.accept();
				// ServiceThread에 BlackjackServer와 함께 같이 넘겨줌
				ServiceThread thread = new ServiceThread(server, serviceSocket);

				System.out.println(server.Clients.size());
				
				// 그리고 그 ServiceThread를 Clients에 담아 관리함
				server.addClient(thread);
				thread.start();

			} catch (IOException e) {
				try {
					serverSocket.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}
