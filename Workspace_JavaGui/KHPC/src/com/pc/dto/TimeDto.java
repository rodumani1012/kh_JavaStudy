package com.pc.dto;

public class TimeDto {
	private int hour;
	private int min;
	private String id;
	private int date;
	
	public TimeDto() {
	}
	public TimeDto(int hour, int min, String id, int date) {
		this.hour = hour;
		this.min = min;
		this.id = id;
		this.date = date;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "TimeDto [hour=" + hour + ", min=" + min + ", id=" + id + ", date=" + date + "]";
	}
}
