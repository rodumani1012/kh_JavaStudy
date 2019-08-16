package com.test01;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 이벤트 정의 방법 1 : this
public class FrameEvent01 extends Frame implements ActionListener{

	Button btn;
	int cnt = 1;
	
	public FrameEvent01() {
		btn = new Button("push");
	}
	
	public void go() {
		add(btn);
		
		btn.addActionListener(this); // 클릭할 때마다 actionPerformed 메소드가 수행 됨
		
		setSize(200,200);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand()); // 버튼의 라벨 전달
		System.out.println(e.getSource()); //이벤트를 만들어준 객체(처음 만들어줬으니 button0)
		System.out.println(e.getID());	//이벤트타입 (clickEvent는 1001)
		System.out.println(e.toString());
		System.out.println("--------");
		
		Button b = (Button)e.getSource();
		System.out.println(b.getLabel()); // 버튼의 라벨 전달.
		System.out.println(b.getName());
		System.out.println(b.getSize());
		
		b.setLabel(""+ cnt++);
	}
	
	public static void main(String[] args) {
		FrameEvent01 f = new FrameEvent01();
		f.go();
	}
}
