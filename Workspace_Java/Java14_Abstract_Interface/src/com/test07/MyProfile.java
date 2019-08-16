package com.test07;

public class MyProfile extends Profile implements Display, Job {

	private String loc;
	
	public MyProfile(String name, String phone) {
		super(name, phone);		
	}

	@Override
	public void jobLoc(String loc) {
		// setter 역할
		// public void setLoc(String loc) { }
		this.loc = loc;
	}

	@Override
	public void display() {
		super.printProfile(); //super.printProfile(); / this.printProfile(); / printProfile();  세가지 모두 다 된다. 상속받았기 때문에.	
		System.out.println("회사 주소 : " + loc);
		System.out.println("회사 직종 : " + jobId);
	}

}
