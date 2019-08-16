package com.test02;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Layout02 implements ActionListener {

	Frame frame;
	Button btn01;
	Button btn02;
	Button btn03;
	Button btn04;
	CardLayout card;
	
	public Layout02() {
		frame = new Frame("CardLayoutExample");
		card = new CardLayout();
		frame.setLayout(card);
		
		btn01 = new Button("첫번째 버튼");
		btn02 = new Button("두번째 버튼");
		btn03 = new Button("세번째 버튼");
		btn04 = new Button("네번째 버튼");
	}
	
	public void go() {
		
		// frame에 버튼 올리고
		frame.add("1", btn01);
		frame.add("2", btn02);
		frame.add("3", btn03);
		frame.add("4", btn04);
		
		// event 걸어주기
		addListener();
		
		// x 누르면 종료
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		// frame 활성화
		frame.setSize(200,200);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		card.next(frame);
	}
	
	private void addListener() {
		btn01.addActionListener(this);
		btn02.addActionListener(this);
		btn03.addActionListener(this);
		btn04.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new Layout02().go();
	}
}

