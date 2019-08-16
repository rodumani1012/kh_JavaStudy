package com.my.client;

import java.awt.*;

import java.awt.event.*;
import javax.swing.*;

import java.net.*;
import java.io.*;

public class client implements ActionListener, Runnable {
	//	GUI 선언
	JFrame jframe = new JFrame("5조 Project");

	Label id_label = new Label("아이디(이름)");
	Label pw_label = new Label("비밀번호");

	Panel login_panel_1 = new Panel();
	Panel login_panel_2 = new Panel();
	Panel newid_panel = new Panel();

	TextField id_input = new TextField(20);
	JPasswordField pw_input = new JPasswordField(20);

	Button newid_btn = new Button("회원가입");
	Button login_btn = new Button("로그인");

	SelectGame selGame = null;

	public Socket clientSocket = null;
	public PrintWriter out = null;
	public BufferedReader in = null;
	
	public client() { // 기본생성자

	}

	public void show() {
		// setting
		Container container = jframe.getContentPane();
		container.setLayout(new FlowLayout());

		login_panel_1.add(id_label);
		login_panel_1.add(id_input);

		login_panel_2.add(pw_label);
		login_panel_2.add(pw_input);

		newid_panel.add(newid_btn);
		newid_panel.add(login_btn);

		container.add(new Label("아이디와 비밀번호를 입력하세요!"), BorderLayout.NORTH);
		container.add(login_panel_1, BorderLayout.CENTER);
		container.add(login_panel_2, BorderLayout.CENTER);
		container.add(newid_panel, BorderLayout.SOUTH);

		// event
		buttonevent();

		jframe.setBounds(550, 250, 300, 200);
		jframe.setVisible(true);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void buttonevent() {
		// 각 버튼 클릭시 클릭 이벤트 발생
		newid_btn.addActionListener(this);
		login_btn.addActionListener(this);
	}

	// 소켓 ip와 port번호 부여 out과 in도 각각 초기화
	public void connect(String host, int port) {
		System.out.println("서버 접속 중....");
		try {
			clientSocket = new Socket(host, port);	//	서버에 아이피주소와 포트번호를 넘기면서 연결
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

		} catch (IOException e) {
			System.out.println("클라이언트 에러발생!!!");
			System.exit(1);
			e.printStackTrace();
		}
	}

	// 소켓 연결 끊기
	public void disconnect() {
		try {
			in.close();
			out.close();
			clientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 회원가입 name과 pw를 받아서 msg의 형태로 서버로 제출
	public void newid(String name, String pw) {
		System.out.println("회원가입 " + name + " " + pw);
		String msg = "REGISTRY " + name + " " + pw;
		this.out.println(msg);	//	ServiceThread에 전달
	}
	
	// BACK버튼 , 취소 버튼 등 그 창을 닫고 클라이언트를 키기 위한 메서드
	public void clientSetvisible() {
		jframe.setVisible(true);
	}

	// 버튼 클릭시 실행
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("회원가입")) {
			new NewID(this);				// NewID 클래스 파일 호출(Client전달)
			jframe.setVisible(false);	// 클라이언트창 안보이게 함
										// dispose() 안 쓴 이유는 dispose를 하게 되면 우리가 호출한 스레드 등 객체가 모두 사라짐
		} else if (e.getActionCommand().equals("로그인")) {
			String login = "LOGIN " + id_input.getText() + " " + pw_input.getText();
			this.out.println(login);		// serviceThread에 로그인메시지 전달 성공하면 스레드에서 보낸 성공 메시지로 인해 selectgame실행
			jframe.setVisible(false);	// 클라이언트창 안보이게 함
		}
	}

	// 메시지를 계속 받기
	@Override
	public void run() {
		try {
			String inputLine;
			while (true) {
				if ((inputLine = in.readLine()) != null) {
					if (inputLine.equals("SUCESS")) {
						// serviceThread에서 로그인에 성공했다면 "SUCESS"메시지 전달로 selectgame을 띄움
						jframe.setVisible(false);		//	클라이언트 창을 안보이게함
						selGame = new SelectGame(this);	//	selectgame 호출(client전달)
						
					} else if (inputLine.equals("FAIL")) {
						// 로그인에 실패했다면
						JOptionPane.showMessageDialog(jframe, "로그인 실패!");	//	"로그인 실패!"라는 메시지창 호출
						jframe.setVisible(true);								//	다시 클라이언트창 보여줌
						
					} else if (inputLine.equals("REGISTRY SUCESS")) {
						// 회원가입에 성공했다면
						jframe.setVisible(true);
						
					} else {
						// 서버에서 메시지가 오면 selGame의 deliveryMsg 메소드에 넘겨줌
						selGame.deliveryMsg(inputLine);
					}
				}
			}
		} catch (IOException e) {
			disconnect();
		}
	}

	public static void main(String[] args) {
		client client = new client();
		client.connect("192.168.110.104", 5555);
		client.show();

		Thread thread = new Thread(client);
		thread.start();
	}
}
