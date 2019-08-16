package com.pc.main;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.pc.biz.PcBiz;
import com.pc.dto.PcDto;
import com.pc.gui.PcGui;

public class UserUpdate extends JFrame implements ActionListener{
	// 필드선언
	JLabel label2_id, label2_pw, label2_pwc, label2_name, label2_dob, label2_addr, label2_tel, t2_id;
	JPasswordField t2_pw, t2_pwc;
	JTextField t2_name, t2_dob, t2_addr, t2_tel;
	JButton update, close2;
	private Panel p;
	PcDto dto = new PcDto();
	PcBiz biz = new PcBiz();

	public UserUpdate(String myid) {

		

		dto = biz.myselectOne(myid);

		setLayout(null);
		label2_id = new JLabel("아  이  디");
		label2_pw = new JLabel("비밀번호");
		label2_pwc = new JLabel("비밀번호 확인");
		label2_name = new JLabel("이         름");
		label2_dob = new JLabel("생년월일");
		label2_addr = new JLabel("주         소");
		label2_tel = new JLabel("전화번호");
		t2_id = new JLabel(dto.getId());
		t2_pw = new JPasswordField(20);
		t2_pwc = new JPasswordField(20);
		t2_name = new JTextField(20);
		t2_dob = new JTextField(20);
		t2_addr = new JTextField(20);
		t2_tel = new JTextField(20);
		update = new JButton("정보수정");
		close2 = new JButton("취소");
	}
	public void go() {
		p=new Panel();
		label2_id.setBounds(50, 20, 100, 50);
	      label2_pw.setBounds(50, 30, 100, 100);
	      label2_pwc.setBounds(50, 40, 100, 150);
	      label2_name.setBounds(50, 50, 100, 200);
	      label2_dob.setBounds(50, 60, 100, 250);
	      label2_tel.setBounds(50, 70, 100, 300);
	      label2_addr.setBounds(50, 80, 100, 350);
	      t2_id.setBounds(140, 32, 150, 25);
	      t2_pw.setBounds(140, 67, 150, 25);
	      t2_pwc.setBounds(140, 102, 150, 25);
	      t2_name.setBounds(140, 137, 150, 25);
	      t2_dob.setBounds(140, 172, 150, 25);
	      t2_tel.setBounds(140, 207, 150, 25);
	      t2_addr.setBounds(140, 245, 150, 25);
	      update.setBounds(50, 280, 100, 25);
	      close2.setBounds(190, 280, 100, 25);
	      
	      update.addActionListener(this);
	      close2.addActionListener(this);
	      
	      add(label2_id);
	      add(label2_pw);
	      add(label2_pwc);
	      add(label2_name);
	      add(label2_dob);
	      add(label2_tel);
	      add(label2_addr);
	      add(t2_id);
	      add(t2_pw);
	      add(t2_pwc);
	      add(t2_name);
	      add(t2_dob);
	      add(t2_tel);
	      add(t2_addr);
	      add(update);
	      add(close2);
	      
	      setBounds(100, 5, 100, 5);
	      setSize(400, 375);
	      setVisible(true);
	      
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().trim().equals("정보수정")) {
            String pw = String.copyValueOf(t2_pw.getPassword());
            String pwc = String.copyValueOf(t2_pwc.getPassword());
            System.out.println("aa "+t2_id.getText());
            dto.setId(t2_id.getText());
            dto.setPw(String.copyValueOf(t2_pw.getPassword()));
            dto.setName(t2_name.getText());
            dto.setDob(t2_dob.getText());
            dto.setTel(t2_tel.getText());
            dto.setAddr(t2_addr.getText());
            if (pw.length() >= 10) {
               if (pw.equals(pwc)) {
                  int res = biz.update(dto);

                  if (res > 0) {
                     JOptionPane.showMessageDialog(null, "수정이 완료 되었습니다.");
                     dispose();
                  } 
               }else {
                  JOptionPane.showMessageDialog(null, "입력하신 비밀번호가 같지 않습니다.");
                  t2_pw.requestFocus();
               }
            }else {
               JOptionPane.showMessageDialog(null, "10자 이상으로 넣어 주세요");
            }
         }
         if (e.getActionCommand().trim().equals("취소")) {
            t2_pw.setText("");
            t2_pwc.setText("");
            t2_name.setText("");
            t2_dob.setText("");
            t2_tel.setText("");
            t2_addr.setText("");
            dispose();
         }
	}

      

   public static void main(String[] args) {

      new PcGui().go();

   }
		
	
}
