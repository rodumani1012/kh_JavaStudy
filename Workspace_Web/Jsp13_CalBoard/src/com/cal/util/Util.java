package com.cal.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import com.cal.dto.CalDto;

public class Util {
	
	private String toDates;
	
	public String getToDates() {
		return toDates;
	}
	
	public void setToDates(String mdate) {
		// yyyy-MM-dd hh:mm:00
		String m = mdate.substring(0,4)+"-"+ // 년
					mdate.substring(4,6)+"-"+ // 월
					mdate.substring(6,8)+" "+ // 일
					mdate.substring(8,10)+":"+ // 시
					mdate.substring(10)+":00"; // 나머지
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년MM월dd일 HH시mm분");
		Timestamp tm = Timestamp.valueOf(m); // 0000:00:00: 00:00:00 형태로 만들어진 것을 
		toDates = sdf.format(tm);			//SimpleDateFormat에서 정한 형식으로 바꿈.
	}
	
	// date : 해당 일, dayOfWeek : 해당 첫 요일
	public static String fontColor(int date, int dayOfWeek) {
		String color = "";
		
		if((dayOfWeek-1+date)%7 == 0) { //토요일
			color = "blue";
		} else if ((dayOfWeek-1+date)%7 == 1) { //일요일
			color = "red";
		} else { // 평일
			color = "black";
		}
		return color;
	}
	
	// 0000 00 00 00 00  12자리의 년, 월, 일, 시, 분이 합쳐진 변수 
	public static String isTwo(String msg) {
		return (msg.length() < 2) ? "0"+msg : msg;
	}
	
	// 해당일의 일정이 몇개 있는지 보여주기
	public static String getCalView(int i, List<CalDto> list) {
		String res = "";
		String d = isTwo(i+"");
		
		for(CalDto dto : list) {
			if(dto.getMdate().substring(6, 8).equals(d)) {
				res += "<p>" // 제목 길이가 6글자 이상이면 ex) '좋은 아침 입니..'  로 표시.
						+ ((dto.getTitle().length() > 6) ? dto.getTitle().substring(0, 6)+".." : dto.getTitle()) 
						+ "</p>";
			}
		}
		return res;
	}
}
