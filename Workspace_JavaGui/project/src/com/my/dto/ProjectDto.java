package com.my.dto;

import java.io.Serializable;

public class ProjectDto implements Serializable{
	private int seq;
	private String myno;
	private String pw;
	private String name;
	private int money;

	public ProjectDto() {

	}

	public ProjectDto(int seq, String myno, String name, String pw, int money) {
		this.seq = seq;
		this.name = name;
		this.pw = pw;
		this.myno = myno;
		this.money = money;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getMyno() {
		return myno;
	}

	public void setMyno(String myno) {
		this.myno = myno;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

}