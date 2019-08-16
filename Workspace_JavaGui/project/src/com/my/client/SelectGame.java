package com.my.client;

import javax.swing.*;

import com.blackjack.BlackjackClient;
import com.seoda.SeodaView;
import com.slot.SlotMachine;

import java.awt.*;
import java.awt.event.*;
import java.net.*;

public class SelectGame implements ActionListener {
	private client client;

	private JFrame jframe;
	private JPanel title, select, exit;
	private JLabel jlabel;
	private JButton btn1, btn2, btn3, btn4, logout;

	SeodaView seoda = null;				//	섯다게임 호출
	BlackjackClient BJClient = null;		//	블랙젝 게임 호출
	SlotMachine SMClient = null;			//	슬롯머신 게임 호출

	//	client를 받는 생성자
	public SelectGame(client client) {
		this.client = client;

		jframe = new JFrame("KH LAND");

		title = new JPanel();
		select = new JPanel();
		exit = new JPanel();

		jlabel = new JLabel("KH LAND");

		btn1 = new JButton("블랙잭");
		btn2 = new JButton("섯다");
		btn3 = new JButton("슬롯머신");
		btn4 = new JButton("기타");

		logout = new JButton("로그아웃");

		show();
	}

	public void show() {
		//	setting
		jframe.setLayout(new FlowLayout());

		title.add(jlabel);

		select.add(btn1);
		select.add(btn2);
		select.add(btn3);
		select.add(btn4);

		exit.add(logout);

		jframe.add(title);
		jframe.add(select);
		jframe.add(exit);

		jframe.setSize(700, 500);
		jframe.setLocation(550, 250);
		jframe.setVisible(true);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.pack();

		//	event
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		logout.addActionListener(this);
	}

	// client에서 넘어온 message(msg)에 따라 맞는 if문 실행
	// serviceThread에서 보낼 때 각 게임에 맞게 문장 앞에 게임이름을 집어넣었음
	public void deliveryMsg(String msg) {
		if (msg.contains("BJ")) {
			BJClient.showhand(msg);
		} else if (msg.contains("SLOT")) {
			SMClient.receiveMsg(msg);
		} else if(msg.contains("SEODA")) {
			seoda.showMsg(msg);
		} else if(msg.equals("BACK")) {
			jframe.setVisible(true);
		}
	}

	//	버튼 클릭 시
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();

		String select = btn.getText();

		//	클릭한 버튼의 이름에 따라 실행(client를 그대로 전달하면서 게임 실행)
		switch (select) {
		case "블랙잭":
			jframe.setVisible(false);
			JOptionPane.showMessageDialog(jframe, "블랙!잭!");
			BJClient = new BlackjackClient(client);
			BJClient.go();
			break;
		case "섯다":
			jframe.setVisible(false);
			JOptionPane.showMessageDialog(jframe, "섯!다!");
			seoda = new SeodaView(client);
			seoda.show();
			break;
		case "슬롯머신":
			jframe.setVisible(false);
			JOptionPane.showMessageDialog(jframe, "슬롯!머신!");
			SMClient = new SlotMachine(client);
			SMClient.slotStart();
			break;
		case "기타":
			JOptionPane.showMessageDialog(jframe, "예정 중입니다.... 다음에 이용해 주세요");
			break;
		case "로그아웃":
			JOptionPane.showMessageDialog(jframe, "들어올땐 마음대로지만 나갈땐 아니란다");
			JOptionPane.showMessageDialog(jframe, "위에 윈도우창 X표를 눌러서 나가주세요");
			break;
		default:
			JOptionPane.showMessageDialog(jframe, "에러 발생!!!");
		}
	}

}
