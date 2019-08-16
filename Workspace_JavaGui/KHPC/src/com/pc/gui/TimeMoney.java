package com.pc.gui;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.pc.admin.IdSearch_AddTime;
import com.pc.admin.IdSearch_OverTime;

public class TimeMoney extends Frame {
	Panel p01;
	Button btnTime, btnMoney;
	
	public TimeMoney() {
		p01 = new Panel();
		btnTime = new Button("시간추가");
		btnMoney = new Button("계산");
	}
	
    public void go() {
        p01.setLayout(new GridLayout(1,2));
        p01.add(btnTime);
        p01.add(btnMoney);
        
        TimeEvent actionEvents = new TimeEvent();
        
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        
        btnTime.addActionListener(actionEvents);
        btnMoney.addActionListener(actionEvents);
        
        add(p01);
        setSize(300,60);
        setVisible(true);
    }
    
    class TimeEvent implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Button btn = (Button)e.getSource();
			System.out.println(btn);
			if(btn.getLabel().equals("시간추가")) {
				new IdSearch_AddTime().go();
			}else if(btn.getLabel().equals("계산")) {
				new IdSearch_OverTime().go();
			}
		}
    }
    
    public static void main(String[] args) {
        new TimeMoney().go();
    }
}