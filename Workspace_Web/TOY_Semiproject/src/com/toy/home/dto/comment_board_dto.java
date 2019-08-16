package com.toy.home.dto;

public class comment_board_dto {

	private int comment_num;
	private int normal_num;
	private int user_num;
	private String user_nickname;
	private String comment_content;
	private int comment_groupno;
	private int comment_groupsq;
	private int comment_titletab;
	private String comment_del;

	public comment_board_dto() {
		super();
	}

	public comment_board_dto(int comment_num, int normal_num, int user_num, String user_nickname,
			String comment_content, int comment_groupno, int comment_groupsq, int comment_titletab,
			String comment_del) {
		super();
		this.comment_num = comment_num;
		this.normal_num = normal_num;
		this.user_num = user_num;
		this.user_nickname = user_nickname;
		this.comment_content = comment_content;
		this.comment_groupno = comment_groupno;
		this.comment_groupsq = comment_groupsq;
		this.comment_titletab = comment_titletab;
		this.comment_del = comment_del;
	}

	public int getComment_num() {
		return comment_num;
	}

	public void setComment_num(int comment_num) {
		this.comment_num = comment_num;
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

	public String getComment_content() {
		return comment_content;
	}

	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}

	public int getComment_groupno() {
		return comment_groupno;
	}

	public void setComment_groupno(int comment_groupno) {
		this.comment_groupno = comment_groupno;
	}

	public int getComment_groupsq() {
		return comment_groupsq;
	}

	public void setComment_groupsq(int comment_groupsq) {
		this.comment_groupsq = comment_groupsq;
	}

	public int getComment_titletab() {
		return comment_titletab;
	}

	public void setComment_titletab(int comment_titletab) {
		this.comment_titletab = comment_titletab;
	}

	public String getComment_del() {
		return comment_del;
	}

	public void setComment_del(String comment_del) {
		this.comment_del = comment_del;
	}

}
