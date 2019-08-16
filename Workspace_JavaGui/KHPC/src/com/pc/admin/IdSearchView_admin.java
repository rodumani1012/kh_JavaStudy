package com.pc.admin;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.pc.dao.PcDao;
import com.pc.dto.PcDto;

public class IdSearchView_admin extends JFrame{
	JPanel p01;
	JLabel lbId, lbPw, lbName, lbTel, lbAddr, lbDob;
	JButton btnSearch, btnCancel;
	JTextField txtId, txtPw, txtName, txtTel, txtAddr, txtDob;
	JPasswordField pfPw;
	
	String id;
	
	GridBagLayout gb;
	
	public void setId(String id) {
		this.id = id;
	}
	
	public IdSearchView_admin() {
		p01 = new JPanel();
		lbId = new JLabel("아이디 : ");
		lbPw = new JLabel("비밀번호 : ");
		lbName = new JLabel("이름 : ");
		lbTel = new JLabel("번호 : ");
		lbAddr = new JLabel("주소 : ");
		lbDob = new JLabel("생일 : ");
		
		txtId = new JTextField(30);
		pfPw = new JPasswordField(30);
		txtName = new JTextField(30);
		txtTel = new JTextField(30);
		txtAddr = new JTextField(30);
		txtDob = new JTextField(30);
		
		btnSearch = new JButton("수정");
		btnCancel = new JButton("취소");
	}
	
	
	
	public void go() {
		p01.setLayout(new GridLayout(7,2));
		p01.add(lbId);
		p01.add(txtId);
		txtId.setEditable(false);
		p01.add(lbPw);
		p01.add(pfPw);
		
		p01.add(lbName);
		p01.add(txtName);
		txtName.setEditable(false);
		p01.add(lbTel);
		p01.add(txtTel);
		txtTel.setEditable(false);
		p01.add(lbAddr);
		p01.add(txtAddr);
		txtAddr.setEditable(false);
		p01.add(lbDob);
		p01.add(txtDob);
		txtDob.setEditable(false);
		System.out.println("id:"+id);
		//
		PcDao dao = new PcDao();
		txtId.setText(String.valueOf(id));
		System.out.println("pw:"+String.valueOf(dao.myselectOne(id).getPw()));
		pfPw.setText(String.valueOf(dao.myselectOne(id).getPw()));
		
		txtName.setText(String.valueOf(dao.myselectOne(id).getName()));
		txtTel.setText(String.valueOf(dao.myselectOne(id).getTel()));
		txtAddr.setText(String.valueOf(dao.myselectOne(id).getAddr()));
		txtDob.setText(String.valueOf(dao.myselectOne(id).getDob()));
		
		
		
		
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
		setSize(300,200);
		setVisible(true);
		
		
	}
	
	class SearchEvent implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			PcDao dao = new PcDao();
			System.out.println(btn);
			if(btn.getLabel().equals("수정")) {
				System.out.println("id2: "+id);
				System.out.println("pw2: "+String.valueOf(pfPw.getText()));
				//new OverTime().go();
				dao.IdSearchUpdate(id, String.valueOf(pfPw.getText()));
				if(dao.IdSearchUpdate(id, String.valueOf(pfPw.getText()))>0) {
					JOptionPane.showMessageDialog(new IdSearchView_admin(), "수정 성공");
					System.out.println("수정 성공");
					dispose();
				}
				PcDto dto = new PcDto();
				dto.setId(String.valueOf(txtId));
				// 함수로 id 넣기
			}else if(btn.getLabel().equals("취소")) {
				dispose();
			}
		}
	}
	
	public static void main(String[] args) {
		new IdSearchView_admin().go();
	}
}
