package com.test01;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

// 이벤트 정의 방법 4.
//	부모의 메소드들을 상속받아서 필요한 것만 사용
public class FrameEvent04 extends Frame implements WindowListener{
	
	Button btn ;
	
	public FrameEvent04() {
		btn = new Button("클릭!!");
		go();
	}

	private void go() {
		add(btn);
		
		// 앞에 this: frame	 뒤의 this : windowListener
		this.addWindowListener(this);
		
		setSize(200,200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new FrameEvent04();
	}

	@Override
	public void windowOpened(WindowEvent e) { // 처음 열었을 때
		System.out.println("windowOpened");
	}

	@Override
	public void windowClosing(WindowEvent e) { // X버튼
		System.out.println("windowClosing");
		System.exit(0); // X버튼으로 닫았을 때 꺼지게 함.
		
	}

	@Override
	public void windowClosed(WindowEvent e) { 
		System.out.println("windowClosed");
		
	}

	@Override
	public void windowIconified(WindowEvent e) { // 최소화
		System.out.println("windowIconified");
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) { // 최소화 반대
		System.out.println("windowDeiconified");
		
	}

	@Override
	public void windowActivated(WindowEvent e) { // 활성화(현재 보고 있을 때)
		System.out.println("windowActivated");
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) { // 비활성화(다른거 보고 있을 때)
		System.out.println("windowDeactivated");
		
	}
}
