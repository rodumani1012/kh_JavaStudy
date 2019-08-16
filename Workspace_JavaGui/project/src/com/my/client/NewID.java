package com.my.client;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class NewID extends client implements ActionListener {
	private String name;
	private String pw;

	private client client;

	JFrame jframe = new JFrame("회원가입 창");

	JLabel name_label = new JLabel("이름");
	JLabel pw_label = new JLabel("비밀번호");

	JTextField name_input = new JTextField(15);
	JPasswordField pw_input = new JPasswordField(15);

	JPanel name_panel = new JPanel();
	JPanel pw_panel = new JPanel();
	JPanel button_panel = new JPanel();

	JButton insert_Btn = new JButton("회원가입");
	JButton cancel_Btn = new JButton("취소");

	//	기본 생성자 -> setting()실행
	public NewID(client client) {
		this.client = client;
		setting();
	}

	public void setting() {
		//	setting
		Container container = jframe.getContentPane();
		container.setLayout(new FlowLayout());

		container.add(new JLabel("회원가입을 위한 정보를 입력해주세요!"), "South");

		name_panel.add(name_label);
		name_panel.add(name_input);

		pw_panel.add(pw_label);
		pw_panel.add(pw_input);

		button_panel.add(insert_Btn);
		button_panel.add(cancel_Btn);

		// event
		buttonevent();

		container.add(name_panel, BorderLayout.CENTER);
		container.add(pw_panel, BorderLayout.CENTER);
		container.add(button_panel, BorderLayout.SOUTH);

		jframe.setBounds(550, 250, 300, 300);
		jframe.setVisible(true);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void buttonevent() {
		insert_Btn.addActionListener(this);
		cancel_Btn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("회원가입")) {
			// 회원가입 창에서 입력받은 값들을 client의 newid 메소드에 넘겨줌
			name = name_input.getText();
			pw = pw_input.getText();
			client.newid(name, pw);			//	클라이언트에 입력받은 name,pw 전달
			
			jframe.setVisible(false);
			client.clientSetvisible();		//	회원가입을 누를경우 이 창은 안보이게 하고 client창을 다시 호출

		} else if (e.getActionCommand().equals("취소")) {
			jframe.setVisible(false);
			client.clientSetvisible();		//	취소를 누를경우 이 창은 안보이게 하고 client창을 다시 호출
		}
	}
}
