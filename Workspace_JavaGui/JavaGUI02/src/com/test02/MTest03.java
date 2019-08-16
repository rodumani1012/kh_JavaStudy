package com.test02;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Action;

public class MTest03 extends Frame{
	
	Panel p01, p02;
	ScrollPane sp;
	TextArea ta;
	
	Button btn01, btn02, btn03, btn04;
	
	Dialog d01;
	FileDialog fd, fs;
	
	public MTest03() {
		p01 = new Panel();
		p02 = new Panel();
		sp = new ScrollPane();
		ta = new TextArea();
		
		btn01 = new Button("1");
		btn02 = new Button("2");
		btn03 = new Button("!");
		btn04 = new Button("4");
		
		d01 = new Dialog(this, "?", true);
		fd = new FileDialog(this, "열기", FileDialog.LOAD);
		fs = new FileDialog(this, "저장", FileDialog.SAVE);
		
	}
	
	public void go() {
		
		p01.setBackground(Color.pink);
		p01.setSize(300, 250);
		p01.setLayout(new BorderLayout());
		p01.add("Center", ta);
		
		p02.add(btn01);
		p02.add(btn02);
		p02.add(btn03);
		p02.add(btn04);
		
		p01.add("South", p02);
		
		d01.setSize(100,100);
		
		sp.add(p01);
		add("Center", sp);
		
		// events
		MyEvents events = new MyEvents();
		this.addWindowListener(events);
		d01.addWindowListener(events);
		btn01.addActionListener(events);
		btn02.addActionListener(events);
		btn03.addActionListener(events);
		btn04.addActionListener(events);
		
		
		setSize(600, 400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MTest03().go();
	}
	
	class MyEvents extends WindowAdapter implements ActionListener{
		
		// 하나만 꺼지게 하는 설정
		@Override
		public void windowClosing(WindowEvent e) {
//			System.exit(0);
			if(e.getSource().getClass() == MTest03.class) {
				System.exit(0);
			}
			if(e.getSource().getClass() == Dialog.class) {
				d01.setVisible(false); //안보이게할 뿐이고 꺼지는건 아님
			}
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().trim().equals("1")) {
				d01.setVisible(true);
			}
			
			if(e.getActionCommand().trim().equals("2")) {
				fd.setVisible(true);
			}
			
			if(e.getActionCommand().trim().equals("4")) {
				fs.setVisible(true);
			}
		}
	}
}
