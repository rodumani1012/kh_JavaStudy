package com.test03;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
 * 1. TextField에 값을 입력하고 enter 치면 다음 포커스로 이동
 * (이름 -> 주소 -> 전화번호 -> 이름 -> 주소....)
 * hint : KeyEvent.VK_ENTER, requestFocus();
 * 
 * 2. 확인 버튼 클릭하면 tAreas에 전체 내용 출력
 * 
 * 3. 취소 버튼 클릭하면 TextField에 있는 값 모두 리셋
 * 
 * 4. 삭제 버튼 클릭하면 tAreas에 있는 전체 내용 리셋
 */
public class FrameTest02 extends Frame {
	
	Panel p01;
	Panel p02;
	Label lbName, lbAddr, lbTel;
	
	TextField txtName, txtAddr, txtTel;
	
	TextArea tAreas;
	
	Button btnOk, btnCn, btnRe;
	
	CheckboxGroup cbg;
	Checkbox c01;
	Checkbox c02;
	
	public FrameTest02() {
		p01 = new Panel();
		lbName = new Label("이  름");
		lbAddr = new Label("주  소");
		lbTel = new Label("전화번호");
		
		txtName = new TextField(30);
		txtAddr = new TextField(30);
		txtTel = new TextField(30);
		
		cbg = new CheckboxGroup();
		c01 = new Checkbox("남성", cbg, true);
		c02 = new Checkbox("여성", cbg, false);
		
		btnOk = new Button("확인");
		btnCn = new Button("취소");
		
		p02 = new Panel();
		tAreas = new TextArea(5,35);
		btnRe = new Button("삭제");
		
	}
	
	public void go() {
		
		this.setLayout(new GridLayout(2,1));
		
		// p01
		p01.setLayout(new GridLayout(5,2));
		p01.add(lbName);
		p01.add(txtName);
		
		p01.add(lbAddr);
		p01.add(txtAddr);
		
		p01.add(lbTel);
		p01.add(txtTel);
		
		p01.add(c01);
		p01.add(c02);
		
		p01.add(btnOk);
		p01.add(btnCn);
		
		
		// p02
		p02.add(tAreas);
		p02.add(btnRe);
		
		// event
		txtName.addKeyListener(new KeyAdapter() { // 이름에서 주소로 커서 이동
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER) {
					txtAddr.requestFocus();
				}
			}
		});
		
		txtAddr.addKeyListener(new KeyAdapter() { // 주소에서 전화번호로 커서 이동
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER) {
					txtTel.requestFocus();
				}
			}
		});
		
		txtTel.addKeyListener(new KeyAdapter() { // 전화번호에서 이름으로 커서 이동
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER) {
					txtName.requestFocus();
				}
			}
		});
		
		MyEvent actionEvent = new MyEvent();
		btnOk.addActionListener(actionEvent);
		btnCn.addActionListener(actionEvent);
		btnRe.addActionListener(actionEvent);

		this.addWindowListener(new WindowAdapter() {
			// WindowAdapter()는 필요한 애들만 오버라이드 할 수 있게 만들었다.
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		// frame에 panel 올리기
		add(p01);
		add(p02);
		
		setSize(300,300);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
		new FrameTest02().go();
	}
	
	class MyEvent implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) { //버튼 클릭하면 이벤트 걸고 싶을 때
			Button btn = (Button)e.getSource();
			
			System.out.println(btn);
			if(btn.getLabel().equals("확인")) {
				String res = "";
				if (c01.getState()) {
					res = c01.getLabel();
				} else if(c02.getState()) {
					res = c02.getLabel();
				}
				
				res += "[" + txtName.getText() + "]";
				res += "\t" + txtAddr.getText();
				res += "\t" + txtTel.getText();
				tAreas.append(res + "\n");
				
			} else if (btn.getLabel().equals("취소")) {
				txtName.setText("");
				txtAddr.setText("");
				txtTel.setText("");
			} else if (btn.getLabel().equals("삭제")) {
				txtName.setText("");
				txtAddr.setText("");
				txtTel.setText("");
				tAreas.setText("");
				tAreas.append("");
			}
			
		}	
	}
}
