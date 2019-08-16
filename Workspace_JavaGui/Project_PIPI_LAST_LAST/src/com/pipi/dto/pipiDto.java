package com.pipi.dto;


public class pipiDto {
	
	private int myno;
	private String myid;
	private String mypw;
	private int myheart;
	private int myfull;
	private int mystamina;
	private int myclean;
	private int mydate;
	private String myallday;
	private String mydisease;
	private String myenabled;
	
	public pipiDto() {}
		
	
	public pipiDto(int myno, String myid, String mypw, int myheart, int myfull, int mystamina, 
			int myclean, int mydate, String myallday, String mydisease, String myenabled) {
	
		this.myno = myno;
		this.myid = myid;
		this.mypw = mypw;
		this.myheart = myheart;
		this.myfull = myfull;
		this.mystamina = mystamina;
		this.myclean = myclean;
		this.mydate = mydate;
		this.myallday = myallday;
		this.mydisease = mydisease;
		this.myenabled = myenabled;
	}

	public int getMyno() {
		return myno;
	}

	public void setMyno(int myno) {
		this.myno = myno;
	}

	public String getMyid() {
		return myid;
	}

	public void setMyid(String myid) {
		this.myid = myid;
	}

	public String getMypw() {
		return mypw;
	}

	public void setMypw(String mypw) {
		this.mypw = mypw;
	}

	public int getMyheart() {
		return myheart;
	}

	public void setMyheart(int myheart) {
		this.myheart = myheart;
	}

	public int getMyfull() {
		return myfull;
	}

	public void setMyfull(int myfull) {
		this.myfull = myfull;
	}

	public int getMystamina() {
		return mystamina;
	}

	public void setMystamina(int mystamina) {
		this.mystamina = mystamina;
	}

	public int getMyclean() {
		return myclean;
	}

	public void setMyclean(int myclean) {
		this.myclean = myclean;
	}

	public int getMydate() {
		return mydate;
	}

	public void setMydate(int mydate) {
		this.mydate = mydate;
	}

	public String getMyallday() {
		return myallday;
	}

	public void setMyallday(String myallday) {
		this.myallday = myallday;
	}

	public String getMydisease() {
		return mydisease;
	}

	public void setMydisease(String mydisease) {
		this.mydisease = mydisease;
	}

	public String getMyenabled() {
		return myenabled;
	}

	public void setMyenabled(String myenabled) {
		this.myenabled = myenabled;
	}
	
}
