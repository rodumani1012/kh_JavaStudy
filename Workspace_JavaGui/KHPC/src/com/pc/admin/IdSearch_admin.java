package com.pc.admin;


import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.pc.dto.PcDto;

public class IdSearch_admin extends JFrame{
	JPanel p01;
	JLabel lbId;
	JButton btnSearch, btnCancel;
	JTextField txtId;
	
	public IdSearch_admin() {
		p01 = new JPanel();
		lbId = new JLabel("아이디");
		txtId = new JTextField(30);
		btnSearch = new JButton("검색");
		btnCancel = new JButton("취소");
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
		
		System.out.println(String.valueOf(txtId.getText()));
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		add(p01);
		setSize(300,100);
		setVisible(true);
	}
	
	class SearchEvent implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			System.out.println(btn);
			if(btn.getLabel().equals("검색")) {
				IdSearchView_admin search = new IdSearchView_admin();
				
				search.setId(String.valueOf(txtId.getText()));
				//new OverTime().go();
				PcDto dto = new PcDto();
				dto.setId(String.valueOf(txtId));
				// 함수로 id 넣기
				System.out.println(String.valueOf(txtId.getText()));
				search.go();
			}else if(btn.getLabel().equals("취소")) {
				dispose();
			}
		}
	}
	
	public static void main(String[] args) {
		new IdSearch_admin().go();
	}
}
