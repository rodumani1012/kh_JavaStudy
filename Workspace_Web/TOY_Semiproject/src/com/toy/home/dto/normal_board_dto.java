package com.toy.home.dto;

import java.sql.Date;

public class normal_board_dto {
	private int normal_num;
	private int user_num;
	private String user_nickname;
	private String normal_title;
	private String normal_content;
	private String normal_category;
	private int normal_count;
	private Date normal_date_create;
	private Date normal_date_update;
	private String normal_premium;
	
	public normal_board_dto() {}
	public normal_board_dto(int normal_num, int user_num, String user_nickname, String normal_title, String normal_content,
			String normal_category, int normal_count, Date normal_date_create, Date normal_date_update,
			String normal_premium) {
		super();
		this.normal_num = normal_num;
		this.user_num = user_num;
		this.user_nickname = user_nickname;
		this.normal_title = normal_title;
		this.normal_content = normal_content;
		this.normal_category = normal_category;
		this.normal_count = normal_count;
		this.normal_date_create = normal_date_create;
		this.normal_date_update = normal_date_update;
		this.normal_premium = normal_premium;
	}
	public int getNormal_num() {
		return normal_num;
	}
	public void setNormal_num(int normal_num) {
		this.normal_num = normal_num;
	}
	public int getUser_num() {
		return user_num;
	}
	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}
	public String getUser_nickname() {
		return user_nickname;
	}
	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}
	public String getNormal_title() {
		return normal_title;
	}
	public void setNormal_title(String normal_title) {
		this.normal_title = normal_title;
	}
	public String getNormal_content() {
		return normal_content;
	}
	public void setNormal_content(String normal_content) {
		this.normal_content = normal_content;
	}
	public String getNormal_category() {
		return normal_category;
	}
	public void setNormal_category(String normal_category) {
		this.normal_category = normal_category;
	}
	public int getNormal_count() {
		return normal_count;
	}
	public void setNormal_count(int normal_count) {
		this.normal_count = normal_count;
	}
	public Date getNormal_date_create() {
		return normal_date_create;
	}
	public void setNormal_date_create(Date normal_date_create) {
		this.normal_date_create = normal_date_create;
	}
	public Date getNormal_date_update() {
		return normal_date_update;
	}
	public void setNormal_date_update(Date normal_date_update) {
		this.normal_date_update = normal_date_update;
	}
	public String getNormal_premium() {
		return normal_premium;
	}
	public void setNormal_premium(String normal_premium) {
		this.normal_premium = normal_premium;
	}
	
}
