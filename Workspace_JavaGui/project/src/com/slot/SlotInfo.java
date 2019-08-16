package com.slot;

public class SlotInfo {
	private int myno;
	private String myname;

	public SlotInfo() {
		super();
	}

	// 로그인 시 등록번호 getter
	public int getMyno() {
		return myno;
	}

	// 번호 setter
	public void setMyno(int myno) {
		this.myno = myno;
	}

	// 로그인 시 이름getter
	public String getMyname() {
		return myname;
	}

	// 이름setter
	public void setMyname(String myname) {
		this.myname = myname;
	}

}