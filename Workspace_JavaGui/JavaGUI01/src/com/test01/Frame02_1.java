package com.test01;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;

public class Frame02_1 extends Frame {
	// 처음 생성시 Frame02_1에 노란 줄 뜨는데 직렬화를 해주세요. 라고 오류 뜸
	// 첫번째 항목으로 에러수정.
	// 데이터를 어떻게 보낼지 정해줘야함.
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Button btn01;
	Button btn02;
	Button btn03;
	Button btn04;
	Button btn05;
	
	public Frame02_1() {
		btn01 = new Button("1.위");
		btn02 = new Button("2.아래");
		btn03 = new Button("3.오른쪽");
		btn04 = new Button("4.중앙");
		btn05 = new Button("5.왼쪽");
	}
	
	public void go() {
		setLayout(new FlowLayout());
		
		add(btn01, BorderLayout.NORTH);
		add(btn02, BorderLayout.SOUTH);
		add(btn03, BorderLayout.EAST);
		add(btn04, BorderLayout.CENTER);
		add(btn05, BorderLayout.WEST);
		
		btn01.setBackground(Color.black);
		btn02.setBackground(Color.BLUE);
		btn03.setBackground(Color.CYAN);
		btn04.setBackground(Color.DARK_GRAY);
		btn05.setBackground(Color.green); //색상 대소문자 상관 없음
		
		btn01.setForeground(Color.white);
		btn02.setForeground(Color.white);
		btn04.setForeground(Color.white);
		
		setSize(300,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		Frame02_1 f = new Frame02_1();
		f.go();
	}
}
