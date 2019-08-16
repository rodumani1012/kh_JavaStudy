package com.pc.gui;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.pc.dao.TimeDao;

public class AddTime extends Frame{
	Panel p01;
	Label lbTime, lbMoney;
	Button btnAdd, btnCancel;
	TextArea txtTime, txtMoney;
	String id;

	public AddTime() {
		p01 = new Panel();
		lbTime = new Label("남은시간");
		lbMoney = new Label("추가결제비용");
		txtTime = new TextArea(3,30);
		txtMoney = new TextArea(3,30);
		btnAdd = new Button("추가");
		btnCancel = new Button("취소");
	}
	public void setId(String id) {
		this.id = id;
	}
	
	//action말고 go에 넣으면 기본으로 남은시간 출력?
	public void go() {
		p01.setLayout(new GridLayout(3,2));
		p01.add(lbTime);
		p01.add(txtTime);
		p01.add(lbMoney);
		p01.add(txtMoney);
		p01.add(btnAdd);
		p01.add(btnCancel);
		
		// 기본 출력
		TimeDao dao = new TimeDao();		
		TimeCal timecal = new TimeCal();
		timecal.setId(id);
		
		int CurrentHour = new TimeCal().TimeCalcul().getHour();
		int StartHour = dao.StartTimeSelect(id).getHour();
		int CurrentMin = new TimeCal().TimeCalcul().getMin();
		int StartMin = dao.StartTimeSelect(id).getMin();
		int OverHour = CurrentHour - StartHour;
		int OverMin = CurrentMin - StartMin;
		
		if(OverHour < 0) {
			OverHour = StartHour - CurrentHour;
		}
		if(OverMin < 0) {
			OverMin = StartMin - CurrentMin;
		}
		
		txtTime.setText(String.valueOf(OverHour)+":"+
				String.valueOf(OverMin));
		
		if((OverHour == 0) && (OverMin > 0)) {
			txtMoney.setText("1000원");
		}else if((OverHour > 0) && (OverMin > 0)){
			txtMoney.setText(((OverHour+1)*1000)+"원");
		}else if((OverHour > 0) && (OverMin == 0)) {
			txtMoney.setText((OverHour*1000)+"원");
		}
		
		// action
		SearchEvent actionEvents = new SearchEvent();
		
		btnAdd.addActionListener(actionEvents);
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
			Button btn = (Button)e.getSource();
			System.out.println(btn);
			if(btn.getLabel().equals("추가")) {
				
			}else if(btn.getLabel().equals("취소")) {
				dispose();
			}
		}
	}
	
	public static void main(String[] args) {
		new AddTime().go();
	}
}
