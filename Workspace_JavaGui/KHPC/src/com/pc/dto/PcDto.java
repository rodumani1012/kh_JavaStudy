package com.pc.dto;

import java.util.Date;

public class PcDto {
	
	private int myno;
	private String id;
	private String pw;
	private String name;
	private String dob;//date of birth 생년월일
	private String tel;
	private String addr;
	private Date jd;//join date  가입날짜

	
	
	public PcDto() {
		
	}

	public PcDto(int myno, String name, String id, String pw, String dob, String tel, String addr, Date jd) {
		
		this.myno = myno;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.dob = dob;
		this.tel = tel;
		this.addr = addr;
		this.jd = jd;
	}

	public int getMyno() {
		return myno;
	}

	public void setMyno(int myno) {
		this.myno = myno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Date getJd() {
		return jd;
	}

	public void setJd(Date jd) {
		this.jd = jd;
	}
	
	
	

}
