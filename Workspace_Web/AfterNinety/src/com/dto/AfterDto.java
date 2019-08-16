package com.dto;

import java.sql.Date;

public class AfterDto {

	private int seq;
	private String id;
	private String pw;
	private Date regdate;
	public AfterDto() {
	}
	public AfterDto(int seq, String id, String pw, Date regdate) {
		this.seq = seq;
		this.id = id;
		this.pw = pw;
		this.regdate = regdate;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
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
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
}
