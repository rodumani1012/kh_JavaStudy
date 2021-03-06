package com.server;

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

public class ClientView extends JFrame implements Runnable {

	// 1.필드에서 선언 (main)
	PcDto dto = null;
	PcBiz biz = null;
	PcDao dao = null;
	String inputLine;

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
	char[] mypw;

	// join
	JLabel join_id, join_pw, join_pwc, join_ex, join_name, join_dob, join_tel, join_addr;
	JTextField tt_id, tt_name, tt_dob, tt_tel, tt_addr;
	JPasswordField tt_pw, tt_pwc;
	JButton chek, join_ok, no;

	// idchek

	// 2.기본생성자
	public ClientView() {

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
		form = new JDialog(this, "회원가입", true);
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
		label2.setBounds(400, 800, 190, 70);
		label_id.setBounds(400, 895, 80, 40);
		label_pw.setBounds(400, 945, 80, 40);
		txt_id.setBounds(50, 50, 200, 30);
		txt_pw.setBounds(50, 90, 200, 30);
		login.setBounds(0, 0, 90, 30);
		join.setBounds(700, 950, 90, 30);
		form.setBounds(500, 300, 510, 410);
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

		join.addActionListener(new PcEvents());

		form.addWindowListener(new PcEvents());
		this.addWindowListener(new PcEvents());

		chek.addActionListener(new PcEvents());
		join_ok.addActionListener(new PcEvents());
		no.addActionListener(new PcEvents());
		login.addActionListener(new PcEvents());
		txt_pw.addKeyListener(new PcEvents()); // 엔터키 쳤을 때 로그인 기능

		// 5. frame에 panel올리기

		add(label);
		add(label2);
		add(label_id);
		add(label_pw);
		add(txt_id);
		add(txt_pw);
		add(login);
		add(join);

		form.add(join_id);
		form.add(join_pw);
		form.add(join_ex);
		form.add(join_pwc);
		form.add(join_name);
		form.add(join_dob);
		form.add(join_tel);
		form.add(join_addr);
		form.add(tt_id);
		form.add(tt_pw);
		form.add(tt_pwc);
		form.add(tt_name);
		form.add(tt_dob);
		form.add(tt_tel);
		form.add(tt_addr);
		form.add(chek);
		form.add(join_ok);
		form.add(no);

		// view

		// 전체화면 모드
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		// setSize(500,400);
		setVisible(true);
		form.setLayout(null);
	}

	class PcEvents extends WindowAdapter implements ActionListener, KeyListener {

		PcDto dto = new PcDto();
		PcBiz biz = new PcBiz();
		PcDao dao = new PcDao();
		//public PrintWriter out = null;
		//BufferedReader in = null;

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().trim().equals("로그인")) {
				PcBiz biz = new PcBiz();
				myid = txt_id.getText();
				mypw = txt_pw.getPassword();
				String id = txt_id.getText();
				String pw = String.copyValueOf(txt_pw.getPassword());

				PcDto dto = biz.login(id, pw);// PcDto dto는 현재 null

				if (dto.getId() != null) { // PcDto에 있는 id가 null(무언가 입력 되었다면 )이 아니라면
					userhome1 home = new userhome1(myid);
					System.out.println(id);
					this.out.println("로그인 " + txt_id.getText() + " " + String.copyValueOf(txt_pw.getPassword()));
				} else {
					JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 확인하세요.");

				}

			}
			if (e.getActionCommand().trim().equals("회원가입")) {
				form.setVisible(true);
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
				if (pw.length() > 10) {

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

		@Override
		public void windowClosing(WindowEvent e) {
			if (e.getSource().getClass() == JDialog.class) {
				form.setVisible(false);
			}
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub 키가 입력 됐을 때

			if (e.getKeyCode() == KeyEvent.VK_ENTER) { // 아이디 비밀번호 누르고 엔터 쳤을 때
				PcBiz biz = new PcBiz();
				myid = txt_id.getText();
				mypw = txt_pw.getPassword();
				String id = txt_id.getText();
				String pw = String.copyValueOf(txt_pw.getPassword());

				PcDto dto = biz.login(id, pw);

				if (dto.getId() != null) {
					userhome1 home = new userhome1(myid);
					System.out.println(id);
					dispose();
					home.go();
				} else {
					JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 확인하세요.");

				}
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			/*
			 * // TODO Auto-generated method stub손가락 뗄 때 if(e.getKeyCode() ==
			 * KeyEvent.VK_ENTER) { myid=txt_id.getText(); System.out.println("fsdf");
			 * userhome home = new userhome(myid); dispose(); home.go(); dispose(); }else {
			 * JOptionPane.showMessageDialog(null,"아이디와 비밀번호를 확인 해 주세요"); }
			 */

		}

		@Override
		public void keyTyped(KeyEvent e) {
			/*
			 * // TODO Auto-generated method stub 키보드 누를때 if(e.getKeyCode() ==
			 * KeyEvent.VK_ENTER) { myid=txt_id.getText(); System.out.println("fsdf");
			 * userhome home = new userhome(myid); dispose(); home.go(); dispose(); }else {
			 * JOptionPane.showMessageDialog(null,"아이디와 비밀번호를 확인 해 주세요"); }
			 */

		}

	}

	public void connect(String host, int port) {
		try {
			serversocket = new Socket(host, port);
			out = new PrintWriter(serversocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(serversocket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void disconnect() {
		try {
			in.close();
			out.close();
			serversocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ClientView client = new ClientView();

		client.connect("localhost", 9997);

		client.go();

		PcDto dto = new PcDto();
		PcBiz biz = new PcBiz();
		PcDao dao = new PcDao();
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
					if ((msg.contains("로그인"))) {
						System.out.println("클라에 로그인성공 도착!");
						userhome1 home = new userhome1(myid);
						dispose();

						home.go();

					}
					// addMessage(in.readLine() + "\n");
				} else {
					System.out.println("클라에 메시지가 오지 않았다!");
				}
			}
		} catch (Exception e) {
			disconnect();

		}

	}

}
