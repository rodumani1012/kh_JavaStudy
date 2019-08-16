package com.pc.admin;

import java.util.Date;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.pc.biz.PcBiz;
import com.pc.dto.PcDto;

public class ID_Search extends JDialog{

	public ID_Search() {}
	public ID_Search(String inputId) {
		
		String []a = {"회원번호","아이디","비밀번호","이름","생년월일","핸드폰","주소","가입날짜"};
		DefaultTableModel model = new DefaultTableModel(a,0);
		
		Condition_search0 c = new Condition_search0();
		PcBiz biz = new PcBiz();
		List<PcDto> list = biz.selectById(inputId);
		for(int i =0; i<list.size(); i++) {

	    	 PcDto dto = list.get(i);
	    	 int myno = dto.getMyno();
	    	 String id = dto.getId();
	    	 String pw = dto.getPw();
	    	 String name = dto.getName();
	    	 String dob = dto.getDob();
	    	 String tel = dto.getTel();
	    	 String addr = dto.getAddr();
	    	 Date jd = dto.getJd();
	    	 model.addRow(new Object[] {myno,id,pw,name,dob,tel,addr,jd});
	     }
		JTable table = new JTable(model);
		 JScrollPane sc = new JScrollPane(table);
		 getContentPane().add(sc);
		 
	}
	public void go() {
		setVisible(true);
		setSize(400,400);
	}
	public static void main(String[] args) {
		new ID_Search().go();
		
	}
}
