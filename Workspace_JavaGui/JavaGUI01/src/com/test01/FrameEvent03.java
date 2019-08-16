package com.test01;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 이벤트 정의 방법 3. 한번만 쓰고 버린다.
// ex) 클릭이벤트가 하나만 있을 때 임시 객체로 만들어서 사용
public class FrameEvent03 extends Frame{
	
	Button btn;
	
	public FrameEvent03( ) {
		btn = new Button("click!!!");
		go();
	}

	private void go() {
		add(btn);
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand());
			}
		});
		
		setSize(200,200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new FrameEvent03();
	}
	
	
	
	
	
	
	
}
