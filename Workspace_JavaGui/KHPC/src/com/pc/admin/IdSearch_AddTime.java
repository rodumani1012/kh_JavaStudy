package com.pc.admin;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.pc.dao.TimeDao;
import com.pc.gui.AddTime;

public class IdSearch_AddTime extends Frame{
	Panel p01;
	Label lbId;
	Button btnSearch, btnCancel;
	TextField txtId;
	String id;

	public IdSearch_AddTime() {
		p01 = new Panel();
		lbId = new Label("아이디");
		txtId = new TextField(30);
		btnSearch = new Button("검색");
		btnCancel = new Button("취소");
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void go() {
		p01.setLayout(new GridLayout(2,2));
		p01.add(lbId);
		p01.add(txtId);
		p01.add(btnSearch);
		p01.add(btnCancel);
		
		SearchEvent actionEvents = new SearchEvent();
		
		btnSearch.addActionListener(actionEvents);
		btnCancel.addActionListener(actionEvents);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		add(p01);
		setSize(300,80);
		setVisible(true);
	}
	
	class SearchEvent implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			AddTime addtime = new AddTime();
			TimeDao dao = new TimeDao();
			Button btn = (Button)e.getSource();
			System.out.println(btn);
			if(btn.getLabel().equals("검색")) {
				// 검색 누르면 다음창 textArea에서 남은시간 출력
				addtime.setId(String.valueOf(txtId.getText()));
				
				addtime.go();
				
				
			}else if(btn.getLabel().equals("취소")) {
				dispose();
			}
		}
	}
	
	public static void main(String[] args) {
		new IdSearch_AddTime().go();
	}
}
