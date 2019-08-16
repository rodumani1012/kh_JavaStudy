package com.board.dto;

public class BoardDto {
	
	private int seq;
	private String title;
	
	
	public BoardDto() {
		super();
	}
	public BoardDto(int seq, String title) {
		super();
		this.seq = seq;
		this.title = title;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
