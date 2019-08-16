package com.toy.project.dto;

public class prj_info_dto {

	private int prj_num;
	private String prj_name;
	private String prj_loc;
	private String user_nickname;

	public prj_info_dto() {
		super();
	}

	public prj_info_dto(int prj_num, String prj_name, String prj_loc, String user_nickname) {
		super();
		this.prj_num = prj_num;
		this.prj_name = prj_name;
		this.prj_loc = prj_loc;
		this.user_nickname = user_nickname;
	}

	public String getUser_nickname() {
		return user_nickname;
	}

	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}

	public int getPrj_num() {
		return prj_num;
	}

	public void setPrj_num(int prj_num) {
		this.prj_num = prj_num;
	}

	public String getPrj_name() {
		return prj_name;
	}

	public void setPrj_name(String prj_name) {
		this.prj_name = prj_name;
	}

	public String getPrj_loc() {
		return prj_loc;
	}

	public void setPrj_loc(String prj_loc) {
		this.prj_loc = prj_loc;
	}

}
