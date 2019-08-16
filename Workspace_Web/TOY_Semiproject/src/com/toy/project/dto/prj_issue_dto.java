package com.toy.project.dto;

public class prj_issue_dto {
	private int issue_num;
	private int prj_num;
	private int board_num;
	private String issue_title;
	private String issue_content;
	private String issue_charge;
	private String issue_deadline;
	private String issue_priority;
	private int issue_parent;
	private String issue_date_create;
	private String issue_date_update;
	private String issue_del;

	public prj_issue_dto() {
	}

	public prj_issue_dto(int issue_num, int prj_num, int board_num, String issue_title, String issue_content,
			String issue_charge, String issue_priority, String issue_deadline, int issue_parent,
			String issue_date_create, String issue_date_update, String issue_del) {
		super();
		this.issue_num = issue_num;
		this.prj_num = prj_num;
		this.board_num = board_num;
		this.issue_title = issue_title;
		this.issue_content = issue_content;
		this.issue_charge = issue_charge;
		this.issue_priority = issue_priority;
		this.issue_deadline = issue_deadline;
		this.issue_parent = issue_parent;
		this.issue_date_create = issue_date_create;
		this.issue_date_update = issue_date_update;
		this.issue_del = issue_del;
	}

	public int getIssue_num() {
		return issue_num;
	}

	public void setIssue_num(int issue_num) {
		this.issue_num = issue_num;
	}

	public int getPrj_num() {
		return prj_num;
	}

	public void setPrj_num(int prj_num) {
		this.prj_num = prj_num;
	}

	public int getBoard_num() {
		return board_num;
	}

	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}

	public String getIssue_title() {
		return issue_title;
	}

	public void setIssue_title(String issue_title) {
		this.issue_title = issue_title;
	}

	public String getIssue_content() {
		return issue_content;
	}

	public void setIssue_content(String issue_content) {
		this.issue_content = issue_content;
	}

	public String getIssue_charge() {
		return issue_charge;
	}

	public void setIssue_charge(String issue_charge) {
		this.issue_charge = issue_charge;
	}

	public String getIssue_priority() {
		return issue_priority;
	}

	public void setIssue_priority(String issue_priority) {
		this.issue_priority = issue_priority;
	}

	public String getIssue_deadline() {
		return issue_deadline;
	}

	public void setIssue_deadline(String issue_deadline) {
		this.issue_deadline = issue_deadline;
	}

	public int getIssue_parent() {
		return issue_parent;
	}

	public void setIssue_parent(int issue_parent) {
		this.issue_parent = issue_parent;
	}

	public String getIssue_date_create() {
		return issue_date_create;
	}

	public void setIssue_date_create(String issue_date_create) {
		this.issue_date_create = issue_date_create;
	}

	public String getIssue_date_update() {
		return issue_date_update;
	}

	public void setIssue_date_update(String issue_date_update) {
		this.issue_date_update = issue_date_update;
	}

	public String getIssue_del() {
		return issue_del;
	}

	public void setIssue_del(String issue_del) {
		this.issue_del = issue_del;
	}

}
