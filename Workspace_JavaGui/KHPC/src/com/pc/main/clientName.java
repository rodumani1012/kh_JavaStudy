package com.pc.main;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.pc.biz.PcBiz;
import com.pc.dao.PcDao;
import com.pc.dto.PcDto;

public class clientName extends JFrame implements ActionListener, Runnable,KeyListener{
	PcDto dto = null;
	PcBiz biz = null;
	PcDao dao = null;
	String inputLine;
	// 1.필드에서 선언 (main)
	Socket serversocket = null;
	Socket socket = null;
	public PrintWriter out = null;
	BufferedReader in = null;
	Image img = null;
	JLabel label_id, label_pw, label, label2;
	JTextField txt_id;
	JPasswordField txt_pw;
	JButton login, join;
	JPanel p, p2;
	JDialog form;
	String myid;

	// join
	JLabel join_id, join_pw, join_pwc, join_ex, join_name, join_dob, join_tel, join_addr;
	JTextField tt_id, tt_name, tt_dob, tt_tel, tt_addr;
	JPasswordField tt_pw, tt_pwc;
	JButton chek, join_ok, no;

	// idchek

	// 2.기본생성자
	public clientName() {

		setLayout(null);
		p = new JPanel();
		p2 = new JPanel();
		p.setLayout(null);
		label = new JLabel(new ImageIcon("C:\\Workspace_JavaGui\\KHPC\\01.jpg"));
		label2 = new JLabel(new ImageIcon("C:\\Workspace_JavaGui\\KHPC\\02.jpg"));
		label_id = new JLabel("아이디 ");
		txt_id = new JTextField(20);
		label_pw = new JLabel("비밀번호 ");
		txt_pw = new JPasswordField(20);
		login = new JButton("로그인");
		join = new JButton("회원가입");
		
		join_id = new JLabel("아이디  ");
		join_pw = new JLabel("비밀번호  ");
		join_pwc = new JLabel("비밀번호  확인");
		join_ex = new JLabel("영(대,소문)자, 숫자만 10자 이상");
		join_name = new JLabel("이름 ");
		join_dob = new JLabel("생년월일");
		join_tel = new JLabel("전화번호");
		join_addr = new JLabel("주소");
		tt_id = new JTextField(20);
		tt_pw = new JPasswordField(20);
		tt_pwc = new JPasswordField(20);
		tt_name = new JTextField(20);
		tt_dob = new JTextField(20);
		tt_tel = new JTextField(20);
		tt_addr = new JTextField(40);
		chek = new JButton("중복체크");
		join_ok = new JButton("가입요청");
		no = new JButton("취소");

	}

	public void setMyid(String myid) {
		this.myid = myid;
	}

	public void go() {
		// 3. panel에 컴포넌트올리기

		label.setBounds(500, 200, 800, 650);
		label2.setBounds(1585, 800, 190, 70);
		label_id.setBounds(1500, 895, 80, 40);
		label_pw.setBounds(1500, 945, 80, 40);
		txt_id.setBounds(1580, 900, 200, 30);
		txt_pw.setBounds(1580, 950, 200, 30);
		login.setBounds(1800, 900, 90, 30);
		join.setBounds(1800, 950, 90, 30);
		
		p2.add(join);

		// 회원가입 폼
		join_id.setBounds(10, 10, 80, 35);
		join_pw.setBounds(10, 54, 80, 35);
		join_ex.setBounds(310, 54, 250, 35);
		join_pwc.setBounds(10, 98, 100, 35);
		join_name.setBounds(18, 144, 80, 35);
		join_dob.setBounds(10, 188, 80, 35);
		join_tel.setBounds(10, 232, 80, 35);
		join_addr.setBounds(18, 282, 80, 35);
		tt_id.setBounds(100, 10, 200, 30);
		tt_pw.setBounds(100, 55, 200, 30);
		tt_pwc.setBounds(100, 100, 200, 30);
		tt_name.setBounds(100, 145, 200, 30);
		tt_dob.setBounds(100, 190, 200, 30);
		tt_tel.setBounds(100, 235, 200, 30);
		tt_addr.setBounds(100, 285, 200, 30);
		chek.setBounds(310, 10, 90, 30);
		join_ok.setBounds(100, 325, 90, 35);
		no.setBounds(208, 325, 90, 35);

		// 4. event
		actionEvent();
		txt_pw.addKeyListener(this);


		add(label);
		add(label2);
		add(label_id);
		add(label_pw);
		add(txt_id);
		add(txt_pw);
		add(login);
		add(join);


		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		
		setVisible(true);
		
	}

	private void actionEvent() {
		join.addActionListener(this);

	

		chek.addActionListener(this);
		join_ok.addActionListener(this);
		no.addActionListener(this);
		login.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().trim().equals("로그인")) {
			myid = txt_id.getText();
			System.out.println("myid:" + myid);
			System.out.println("pw"+String.copyValueOf(txt_pw.getPassword()));
			this.out.println("로그인 " + txt_id.getText() + " " + String.copyValueOf(txt_pw.getPassword()));
															
		}
		
		if (e.getActionCommand().trim().equals("회원가입")) {
			new userinsert().go();
		}
		if (e.getActionCommand().trim().equals("중복체크")) {
			PcBiz biz = new PcBiz();
			String id = tt_id.getText();

			if (biz.idchek(id).getId() == null) {
				JOptionPane.showMessageDialog(null, "사용이 가능 한 아이디 입니다.");
				tt_pw.requestFocus();
			} else {
				JOptionPane.showMessageDialog(null, "이미 가입 된 아이디 입니다. 다른 아이디를 입력 해 주세요.");
				tt_id.requestFocus();
			}

			// 저장 하면서 from창 닫기
		}
		if (e.getActionCommand().trim().equals("가입요청")) {
			String pw = String.copyValueOf(tt_pw.getPassword());
			String pwc = String.copyValueOf(tt_pwc.getPassword());
			dto.setId(tt_id.getText());
			dto.setPw(String.copyValueOf(tt_pw.getPassword()));
			dto.setName(tt_name.getText());
			dto.setDob(tt_dob.getText());
			dto.setTel(tt_tel.getText());
			dto.setAddr(tt_addr.getText());
			if (pw.length() >= 10) {

				if (pw.equals(pwc)) {
					int res = biz.insert(dto);

					if (res > 0) {
						JOptionPane.showMessageDialog(null, "회원가입이 완료 되었습니다!");
						form.dispose();
					}
				} else {
					JOptionPane.showMessageDialog(null, "입력하신 비밀번호가 같지 않습니다.");
					tt_pw.requestFocus();
				}
			} else {
				JOptionPane.showMessageDialog(null, "10자 이상으로 넣어 주세요");
			}
		}

		if (e.getActionCommand().trim().equals("취소")) {
			form.dispose();
		}
	}


	public void connect(String host, int port) {
		try {
			serversocket = new Socket(host, port);
			out = new PrintWriter(serversocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(serversocket.getInputStream()));
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

	public void disconnect() {
		try {
			in.close();
			out.close();
			serversocket.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		clientName client = new clientName();

		client.connect("192.168.110.104", 9997);

		client.go();


		Thread thread = new Thread(client);
		thread.start();

	}

	@Override
	public void run() {

		try {
			String msg;
			while (true) {
				if ((msg = in.readLine()) != null) {
					System.out.print("msg :" + msg);
					if ((msg.contains("성공"))) {
						System.out.println("클라에 로그인성공 도착!");
						userhome home = new userhome(myid);
						dispose();

						home.go();

					}else if((msg.contains("실패"))){
						JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 확인하세요.");
					}else if((msg.contains("자리"))) {
						JOptionPane.showMessageDialog(null, "자리가 꽉 찼습니다.");
					}
					
				} else {
					
				}
			}
		} catch (Exception e) {
			disconnect();

		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub 키가 입력 됐을 때

		if (e.getKeyCode() == KeyEvent.VK_ENTER) { // 아이디 비밀번호 누르고 엔터 쳤을 때
			
			myid = txt_id.getText();
			this.out.println("로그인 " + txt_id.getText() + " " + String.copyValueOf(txt_pw.getPassword()));

			
		}
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
