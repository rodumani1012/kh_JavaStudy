package com.dto;

// VO : Value Object(값을 저장하는 객체)
// DTO : Date Transfer Object(값을 전달하는 객체)
public class MyTestDto {

	private int mno;
	private String mname;
	private String nickName;

	public MyTestDto() {

	}

	public MyTestDto(int mno, String mname, String nickName) {
		this.mno = mno;
		this.mname = mname;
		this.nickName = nickName;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return mno + " \t" + mname + " \t" + nickName;
	}
}
