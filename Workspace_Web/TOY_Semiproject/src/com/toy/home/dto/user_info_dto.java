package com.toy.home.dto;

import java.util.Date;

public class user_info_dto {

	private int user_num;
	private String user_id;
	private String user_pw;
	private String user_name;
	private String user_email;
	private String user_nickname;
	private String user_enabled;
	private String user_grade;
	private Date user_date_create;
	private Date user_date_update;

	public user_info_dto() {
		super();
	}

	public user_info_dto(int user_num, String uer_id, String user_pw, String user_name, String user_email,
			String user_nickname, String user_enabled, String user_grade, Date user_date_create,
			Date user_date_update) {
		super();
		this.user_num = user_num;
		this.user_id = uer_id;
		this.user_pw = user_pw;
		this.user_name = user_name;
		this.user_email = user_email;
		this.user_nickname = user_nickname;
		this.user_enabled = user_enabled;
		this.user_grade = user_grade;
		this.user_date_create = user_date_create;
		this.user_date_update = user_date_update;
	}

	public int getUser_num() {
		return user_num;
	}

	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String uer_id) {
		this.user_id = uer_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_nickname() {
		return user_nickname;
	}

	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}

	public String getUser_enabled() {
		return user_enabled;
	}

	public void setUser_enabled(String user_enabled) {
		this.user_enabled = user_enabled;
	}

	public String getUser_grade() {
		return user_grade;
	}

	public void setUser_grade(String user_grade) {
		this.user_grade = user_grade;
	}

	public Date getUser_date_create() {
		return user_date_create;
	}

	public void setUser_date_create(Date user_date_create) {
		this.user_date_create = user_date_create;
	}

	public Date getUser_date_update() {
		return user_date_update;
	}

	public void setUser_date_update(Date user_date_update) {
		this.user_date_update = user_date_update;
	}

}
