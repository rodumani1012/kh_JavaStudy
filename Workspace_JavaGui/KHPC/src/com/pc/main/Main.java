package com.pc.main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.ObjectInputStream.GetField;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import com.pc.admin.Condition_search0;
import com.pc.admin.IdSearch_admin;
import com.pc.admin.Member_List;
import com.pc.biz.PcBiz;
import com.pc.dto.PcDto;

public class Main extends JFrame implements ActionListener{
	Socket serversocket = null;
	Socket socket = null;
	PrintWriter out = null;
	BufferedReader in = null;
	JButton btn, btn1;

	JTextPane seat1, seat2, seat3, seat4, seat5, seat6, outputArea;

	static int count = 1;

	public Main() {
		Clients = new Vector<>();

		setLayout(null);
		outputArea = new JTextPane();

		outputArea.setEditable(false);
		add(outputArea, "Center");
		seat1 = new JTextPane();
		StyledDocument doc = seat1.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);

		
		seat1.setBounds(150, 143, 250, 250);
		seat1.setText("1번 자리");
		seat1.setBackground(Color.gray);

		add(seat1);

		seat2 = new JTextPane();
		seat2.setBounds(700, 143, 250, 250);
		seat2.setBackground(Color.gray);
		seat2.setText("2번자리");
		StyledDocument doc1 = seat2.getStyledDocument();
		SimpleAttributeSet center1 = new SimpleAttributeSet();
		StyleConstants.setAlignment(center1, StyleConstants.ALIGN_CENTER);
		doc1.setParagraphAttributes(0, doc1.getLength(), center1, false);
		

		add(seat2);

		seat3 = new JTextPane();
		seat3.setBounds(1250, 143, 250, 250);
		seat3.setBackground(Color.gray);
		seat3.setText("3번자리");
		StyledDocument doc2 = seat3.getStyledDocument();
		SimpleAttributeSet center2 = new SimpleAttributeSet();
		StyleConstants.setAlignment(center2, StyleConstants.ALIGN_CENTER);
		doc2.setParagraphAttributes(0, doc2.getLength(), center2, false);

		add(seat3);

		seat4 = new JTextPane();
		seat4.setBounds(150, 500, 250, 250);
		seat4.setBackground(Color.gray);
		
		seat4.setText("4번자리");
		StyledDocument doc3 = seat4.getStyledDocument();
		SimpleAttributeSet center3 = new SimpleAttributeSet();
		StyleConstants.setAlignment(center3, StyleConstants.ALIGN_CENTER);
		doc3.setParagraphAttributes(0, doc3.getLength(), center3, false);

		add(seat4);

		seat5 = new JTextPane();
		seat5.setBounds(700, 500, 250, 250);
		seat5.setBackground(Color.gray);
		seat5.setText("5번자리");

		StyledDocument doc4 = seat5.getStyledDocument();
		SimpleAttributeSet center4 = new SimpleAttributeSet();
		StyleConstants.setAlignment(center4, StyleConstants.ALIGN_CENTER);
		doc4.setParagraphAttributes(0, doc4.getLength(), center4, false);

		add(seat5);

		seat6 = new JTextPane();
		seat6.setBounds(1250, 500, 250, 250);
		seat6.setBackground(Color.gray);
		seat6.setText("6번자리");
		StyledDocument doc5 = seat6.getStyledDocument();
		SimpleAttributeSet center5 = new SimpleAttributeSet();
		StyleConstants.setAlignment(center5, StyleConstants.ALIGN_CENTER);
		doc5.setParagraphAttributes(0, doc5.getLength(), center5, false);

		add(seat6);
		
		btn = new JButton("조건 검색");
		btn.setSize(150, 80);
		btn.setLocation(500, 50);
		add(btn);
		btn.addActionListener(this);

		btn1 = new JButton("회원정보 조회");
		btn1.setSize(150, 80);
		btn1.setLocation(1000, 50);
		add(btn1);
		btn1.addActionListener(this);

	}

	Vector<NetworkThread> Clients;

	public void addClient(NetworkThread nt) {
		Clients.addElement(nt);
	}

	public void removeClient(NetworkThread nt) {
		Clients.removeElement(nt);

	}

	public static void main(String[] args) {
		Main sv = new Main();
		sv.pack();
		sv.setSize(1000, 500);
		sv.setVisible(true);
		sv.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		ServerSocket serverSocket = null;
		int port = 9997;

		try {
			serverSocket = new ServerSocket(port);
			System.out.println("서버 연결 완료");

		} catch (IOException e) {
			System.out.println("\"연결실패\"");
			e.printStackTrace();
		}
		try {
			while (true) {
				Socket serviceSocket;

				serviceSocket = serverSocket.accept();
				

				NetworkThread thread = new NetworkThread(sv, serviceSocket, count);
				thread.start();
				sv.addClient(thread);
				
				count++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			serverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void seat(int count, String loginId) {
		DateFormat dateFormat = new SimpleDateFormat("HH:mm");
		Date date = new Date();
		String start = dateFormat.format(date);
		PcBiz biz = new PcBiz();
		PcDto dto = biz.myselectOne(loginId);
		switch (count) {
		case 1:
			System.out.println(start);
			System.out.println("myid : " + loginId);
			seat1.setBackground(Color.red);
			seat1.setText(dto.getName() + "님 \n 시작시간은 " + start +"입니다.");
			StyledDocument doc = seat1.getStyledDocument();
			SimpleAttributeSet center = new SimpleAttributeSet();
			StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
			doc.setParagraphAttributes(0, doc.getLength(), center, false);

			break;
		case 2:
			seat2.setBackground(Color.red);
			seat2.setText(dto.getName() + "님 \n 시작시간은 " + start +"입니다.");
			StyledDocument doc1 = seat2.getStyledDocument();
			SimpleAttributeSet center1 = new SimpleAttributeSet();
			StyleConstants.setAlignment(center1, StyleConstants.ALIGN_CENTER);
			doc1.setParagraphAttributes(0, doc1.getLength(), center1, false);
			break;
		case 3:
			seat3.setBackground(Color.red);
			seat3.setText(dto.getName() + "님 \n 시작시간은 " + start +"입니다.");
			StyledDocument doc2 = seat3.getStyledDocument();
			SimpleAttributeSet center2 = new SimpleAttributeSet();
			StyleConstants.setAlignment(center2, StyleConstants.ALIGN_CENTER);
			doc2.setParagraphAttributes(0, doc2.getLength(), center2, false);
			break;
		case 4:
			seat4.setBackground(Color.red);
			seat4.setText(dto.getName() + "님 \n 시작시간은 " + start +"입니다.");
			StyledDocument doc3 = seat4.getStyledDocument();
			SimpleAttributeSet center3 = new SimpleAttributeSet();
			StyleConstants.setAlignment(center3, StyleConstants.ALIGN_CENTER);
			doc3.setParagraphAttributes(0, doc3.getLength(), center3, false);
			break;
		case 5:
			seat5.setBackground(Color.red);
			seat5.setText(dto.getName() + "님 \n 시작시간은 " + start +"입니다.");
			StyledDocument doc4 = seat5.getStyledDocument();
			SimpleAttributeSet center4 = new SimpleAttributeSet();
			StyleConstants.setAlignment(center4, StyleConstants.ALIGN_CENTER);
			doc4.setParagraphAttributes(0, doc4.getLength(), center4, false);
			break;
		case 6:
			seat6.setBackground(Color.red);
			seat6.setText(dto.getName() + "님 \n 시작시간은 " + start +"입니다.");
			StyledDocument doc5 = seat6.getStyledDocument();
			SimpleAttributeSet center5 = new SimpleAttributeSet();
			StyleConstants.setAlignment(center5, StyleConstants.ALIGN_CENTER);
			doc5.setParagraphAttributes(0, doc5.getLength(), center5, false);
			break;

		}

	}
//	public void logOut() {
//		
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jbtn = (JButton)e.getSource();
		if(jbtn.getLabel().equals("회원정보 조회")) {
			new Member_List();
		}else if(jbtn.getLabel().equals("조건 검색")) {
			
			new IdSearch_admin().go();
		}
		
		
	}

}
