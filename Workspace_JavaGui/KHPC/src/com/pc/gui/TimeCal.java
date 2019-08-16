package com.pc.gui;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.pc.dao.TimeDao;
import com.pc.dto.TimeDto;

public class TimeCal {
	String id;
	public void setId(String id) {
		this.id = id;
	}
	public TimeDto TimeCalcul() {
		TimeDao dao = new TimeDao();
		TimeDto dto = new TimeDto();
		TimeDto res = new TimeDto();	// error1
		int CurrentHour, CurrentMin, StartHour, StartMin, EndHour, EndMin,
			CurrentDate, StartDate, CurrentHourChk;
		
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		dayTime.format(new Date(System.currentTimeMillis()));
		
		Calendar date = Calendar.getInstance();
		date.setTimeInMillis(System.currentTimeMillis());
		
		CurrentDate = date.get(Calendar.DATE);
		CurrentHour = date.get(Calendar.HOUR_OF_DAY);
		CurrentMin = date.get(Calendar.MINUTE);
		
//		if(date.get(Calendar.AM_PM) == Calendar.AM) {
//			CurrentHour = date.get(Calendar.HOUR);
//		}else if(date.get(Calendar.AM_PM) == Calendar.PM) {
//			CurrentHour = date.get(Calendar.HOUR);
//		}
		
		
		System.out.println("TimeCalId : "+id);
		System.out.println("CurrentHour:"+CurrentHour);
		StartHour = dao.StartTimeSelect(id).getHour();
		StartMin = dao.StartTimeSelect(id).getMin();

		// if 추가 필요
		EndHour = CurrentHour - StartHour;
		EndMin = CurrentMin - StartMin;
		System.out.println(CurrentHour);
		System.out.println(CurrentMin);
		
		res.setDate(CurrentDate);
		res.setHour(CurrentHour);
		res.setMin(CurrentMin);
		
		
		
		return res;
	}
	
	
	
}
