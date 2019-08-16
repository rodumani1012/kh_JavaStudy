package com.test01;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameEventTest extends Frame{

	Panel p01, p02, p03, p04;
	Checkbox c01, c02, c03;
	
	// awt에는 radiobox가 없는 대신, CheckboxGroup으로 묶어서 사용한다.
	CheckboxGroup cbg;
	
	Choice cc;
	List lst; // java.utill 이 아닌 java.awt 에 있는 List!! 
	TextField tf;
	
	public FrameEventTest() {
		p01 = new Panel();
		p02 = new Panel();
		p03 = new Panel();
		p04 = new Panel();
		
		cbg = new CheckboxGroup();
		c01 = new Checkbox("one", cbg, true);
		c02 = new Checkbox("two", cbg, false);
		c03 = new Checkbox("three", cbg, false);
		
		cc = new Choice();
		lst = new List(5, false); // true/false : 여러개가 선택될 수 있는지에대한 여부
		tf = new TextField(30);
	}
	
	public void go() {
		
		setLayout(new GridLayout(4,1));
		
		// p01
		p01.add(c01);
		p01.add(c02);
		p01.add(c03);
		
		// p02
		p02.add(cc);
		cc.add("봄");
		cc.add("여름");
		cc.add("가을");
		cc.add("겨울");
		
		// p03
		p03.add(lst);
		lst.add("일");
		lst.add("월");
		lst.add("화");
		lst.add("수");
		lst.add("목");
		lst.add("금");
		lst.add("토");
		
		// p04
		p04.add(tf);
		tf.setEchoChar('*');
		
		// frame에 패널을 올리자
		add(p01);
		add(p02);
		add(p03);
		add(p04);

		// event 만들자
		// x 누르면 종료
		this.addWindowListener(new WindowAdapter() {
			// WindowAdapter()는 필요한 애들만 오버라이드 할 수 있게 만들었다.
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		MyCheckEvent myEvent = new MyCheckEvent();		
		c01.addItemListener(myEvent);
		c02.addItemListener(myEvent);
		c03.addItemListener(myEvent);
		
		cc.addItemListener(myEvent);
		
		lst.addItemListener(myEvent);
		
		tf.addKeyListener(myEvent);
		
		tf.addTextListener(myEvent);
		
		setSize(400,400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new FrameEventTest().go();
	}
	
	class MyCheckEvent implements ItemListener, KeyListener, TextListener{

	      @Override
	      public void itemStateChanged(ItemEvent e) {
	         System.out.println(e);
	         
	         /*
	         if(e.getStateChange() == ItemEvent.SELECTED) {
	            System.out.println(e.getItem() + " : selected!!");
	         }
	         */
	         
	         /* ClassException 오류 발생
	         Checkbox ch = (Checkbox)e.getSource();
	         if(ch.getState()) {
	        	 System.out.println(ch.getLabel() + " : 체크");
	         }
	         */
	         
	         /*
	         if(cc.getSelectedItem() == "봄") {
	        	 p02.setBackground(Color.pink);
	         } else if(cc.getSelectedItem() == "여름") {
	        	 p02.setBackground(Color.red);
	         } else if(cc.getSelectedItem() == "가을") {
	        	 p02.setBackground(Color.yellow);
	         } else if(cc.getSelectedItem() == "겨울") {
	        	 p02.setBackground(Color.black);
	         }
	         */
	         
	         // instanceof : 해당 객체의 type을 판별해줌
	         if(e.getSource() instanceof Checkbox) {
	        	 System.out.println(((Checkbox)e.getSource()).getLabel() + " : 체크");
	         } else if(e.getSource() instanceof Choice) {
	        	 if(cc.getSelectedItem() == "봄") {
	        		 p02.setBackground(Color.pink);
	        	 } else if(cc.getSelectedItem() == "여름") {
		        	 p02.setBackground(Color.red);
		         } else if(cc.getSelectedItem() == "가을") {
		        	 p02.setBackground(Color.yellow);
		         } else if(cc.getSelectedItem() == "겨울") {
		        	 p02.setBackground(Color.black);
		         }
	         } else if(e.getSource() instanceof List) {
	        	 String[] res = ((List)e.getSource()).getSelectedItems();
	        	 for(String s : res) {
	        		 System.out.println(s + " : select list");
	        	 }
	         } 
	      }

		@Override
		public void keyPressed(KeyEvent e) {
			// keyPressed
			if(e.getKeyChar() == KeyEvent.VK_ENTER) {
				// 입력된 문자가 엔터라면
				System.out.println(((TextField)e.getSource()).getText());
			}
		}
		
		@Override
		public void keyTyped(KeyEvent arg0) {
//			System.out.println("keyTyped : 손가락 눌렀을 때");
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
//			System.out.println("keyReleased : 손가락 뗄 때");
		}

		@Override
		public void textValueChanged(TextEvent e) {
			if(e.getSource() instanceof TextField) {
				TextField t = (TextField)e.getSource();
				System.out.println(t.getText());
			}
		}
	      
	   }
	
}
