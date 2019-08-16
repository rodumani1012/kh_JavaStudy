package com.toy.project.dto;

public class prj_history_dto {

	private String history_create;
	private String history_record;

	public prj_history_dto() {
		super();
	}

	public prj_history_dto(String history_create, String history_record) {
		super();
		this.history_create = history_create;
		this.history_record = history_record;
	}

	public String getHistory_create() {
		return history_create;
	}

	public void setHistory_create(String history_create) {
		this.history_create = history_create;
	}

	public String getHistory_record() {
		return history_record;
	}

	public void setHistory_record(String history_record) {
		this.history_record = history_record;
	}

}
