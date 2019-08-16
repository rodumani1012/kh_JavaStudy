package com.toy.project.dto;

public class prj_in_user_dto {
	private int user_num;
	private int prj_num;
	
	public prj_in_user_dto() {}
	public prj_in_user_dto(int user_num, int prj_num) {
		super();
		this.user_num = user_num;
		this.prj_num = prj_num;
	}
	public int getUser_num() {
		return user_num;
	}
	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}
	public int getPrj_num() {
		return prj_num;
	}
	public void setPrj_num(int prj_num) {
		this.prj_num = prj_num;
	}
	
	
}
