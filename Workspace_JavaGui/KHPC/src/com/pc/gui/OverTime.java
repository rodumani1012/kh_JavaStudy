package com.pc.gui;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.pc.dao.TimeDao;
import com.pc.dto.TimeDto;

public class OverTime extends Frame{
	Panel p01;
	Label lbTime, lbMoney;
	Button btnAdd, btnCancel;
	TextArea txtTime, txtMoney;
	String id;

	public OverTime() {
		p01 = new Panel();
		lbTime = new Label("추가사용시간");
		lbMoney = new Label("추가결제비용");
		txtTime = new TextArea(3,30);	// 초과시간 출력해야함
		txtMoney = new TextArea(3,30);
		btnAdd = new Button("계산");
		btnCancel = new Button("취소");
		TimeDto dto = new TimeDto();
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void go() {
		p01.setLayout(new GridLayout(3,2));
		p01.add(lbTime);
		p01.add(txtTime);
		p01.add(lbMoney);
		p01.add(txtMoney);
		p01.add(btnAdd);
		p01.add(btnCancel);
		
		TimeDto dto = new TimeDto();
		SearchEvent actionEvents = new SearchEvent();
		
		System.out.println("OverTime2 : "+id);
		
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
			TimeDto dto = new TimeDto();
			TimeDao dao = new TimeDao();
			Button btn = (Button)e.getSource();
			System.out.println(btn);
			if(btn.getLabel().equals("계산")) {	//==res		// new TimeCal().getHour();
				TimeCal timecal = new TimeCal();
				timecal.setId(id);
				System.out.println("overAction : "+id);
				
				//StartHour = dao.StartTimeSelect(id).getHour();
				//StartMin = dao.StartTimeSelect(id).getMin();
				System.out.println("this:"+String.valueOf(dao.StartTimeSelect(id).getHour()));
				
				int CurrentDate = new TimeCal().TimeCalcul().getDate();
				int StartDate = dao.StartTimeSelect(id).getDate();
				int CurrentHour = new TimeCal().TimeCalcul().getHour();
				int StartHour = dao.StartTimeSelect(id).getHour();
				int CurrentMin = new TimeCal().TimeCalcul().getMin();
				int StartMin = dao.StartTimeSelect(id).getMin();
				
				System.out.println("3:"+CurrentHour);
				
				// if 날짜가 넘어가면 (다음달 제외)
				if(CurrentDate > StartDate) {
					// if(hour 12 이상 이하 검사)	? += 12 해야하나
					CurrentHour = CurrentHour + (CurrentDate - StartDate) * 24;	// 들어갔다오면 왜 13->24
					System.out.println("CurrentHour:"+CurrentHour);
					System.out.println("CurrentDate:"+CurrentDate);
					System.out.println("StartDate:"+StartDate);
				}else if(CurrentDate < StartDate) {
					// 1일로 넘어가는경우? 일단 24시간 이상 안한다 치고. 24시간 한다치면 month까지 받아야 할듯
					CurrentHour =+ 24;
				}
				
				if(CurrentMin < StartMin) {
					CurrentMin = CurrentMin + 60;
					CurrentHour = CurrentHour - 1;
				}//?
				
//				if(OverHour < 0) {
//					OverHour = StartHour - CurrentHour;
//				}
//				if(OverMin < 0) {
//					OverMin = StartMin - CurrentMin;
//				}
				int OverHour = CurrentHour - StartHour;
				int OverMin = CurrentMin - StartMin;
				
				if(OverMin < 10) {
					txtTime.setText(String.valueOf(OverHour)+":0"+
							String.valueOf(OverMin));
				}else {
					txtTime.setText(String.valueOf(OverHour)+":"+
							String.valueOf(OverMin));
				}
				
				// 날짜가 넘어갈경우 if문 추가
				
				if((OverHour == 0) && (OverMin > 0)) {
					txtMoney.setText("1000원");
				}else if((OverHour > 0) && (OverMin > 0)){
					txtMoney.setText(((OverHour+1)*1000)+"원");
				}else if((OverHour > 0) && (OverMin == 0)) {
					txtMoney.setText((OverHour*1000)+"원");
				}
				
//				txtTime.setText(String.valueOf(dao.StartTimeSelect(id).getHour())+":"+
//						String.valueOf(dao.StartTimeSelect(id).getMin()));
//				
//				txtTime.setText(String.valueOf(new TimeCal().TimeCalcul().getHour())+":"+
//						String.valueOf(new TimeCal().TimeCalcul().getMin()));
				
				//if()
				System.out.println("2:"+StartDate);
				System.out.println("overtimeId222 : "+id);
			}else if(btn.getLabel().equals("취소")) {
				dispose();
			}
		}
	}
	
	// timeCal
	
	public static void main(String[] args) {
		new OverTime().go();
	}
}
