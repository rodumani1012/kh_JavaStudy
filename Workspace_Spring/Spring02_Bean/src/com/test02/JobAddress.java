package com.test02;

public class JobAddress {

	private Address addr;
	private String jobName;
	
	public JobAddress() {
		this.addr = new Address();
		this.jobName = "도적";
	}

	public JobAddress(Address addr, String jobName) {
		this.addr = addr;
		this.jobName = jobName;
	}
	
	public Address getAddr() {
		return addr;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	
	@Override
	public String toString() {
		return addr + "\t 직업 : " + jobName;
	}
	
}
