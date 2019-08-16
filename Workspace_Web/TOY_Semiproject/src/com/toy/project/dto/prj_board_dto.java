package com.toy.project.dto;

public class prj_board_dto {

	private int board_num;
	private int prj_num;
	private String board_title;

	public prj_board_dto() {
		super();
	}

	public prj_board_dto(int board_num, int prj_num, String board_title) {
		super();
		this.board_num = board_num;
		this.prj_num = prj_num;
		this.board_title = board_title;
	}

	public int getBoard_num() {
		return board_num;
	}

	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}

	public int getPrj_num() {
		return prj_num;
	}

	public void setPrj_num(int prj_num) {
		this.prj_num = prj_num;
	}

	public String getBoard_title() {
		return board_title;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}

}
