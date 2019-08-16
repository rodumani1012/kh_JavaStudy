package com.test01;

public class NickNamePrn {

	private NickName NickName;

	public NickNamePrn() {

	}

	public NickNamePrn(NickName nickName) {
		NickName = nickName;
	}

	public NickName getNickName() {
		return NickName;
	}

	public void setNickName(NickName nickName) {
		NickName = nickName;
	}

	@Override
	public String toString() {
		return "나의 " + NickName;
	}
	
	
}
