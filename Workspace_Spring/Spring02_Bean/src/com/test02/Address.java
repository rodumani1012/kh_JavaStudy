package com.test02;

public class Address {

	private String name;
	private String addr;
	private String tel;
	
	public Address() {
		this.name = "홍길동";
		this.addr = "서울시 강남구";
		this.tel = "010-1234-5678";
	}

	public Address(String name, String addr, String tel) {
		this.name = name;
		this.addr = addr;
		this.tel = tel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "이름 : " + name + "\t 주소 : " + addr + "\t 전화번호 : " + tel;
	}

}
