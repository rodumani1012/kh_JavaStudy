package dto.inven;

import java.util.Date;

public class InvenRamen {
	private String name;
	private int amount;
	private Date etc;
	
	public InvenRamen() {
		
	}
	
	public InvenRamen(String name, int amount, Date etc) {
		this.name = name;
		this.amount = amount;
		this.etc = etc;
	}
	
	public InvenRamen(String name) {
		this.amount = amount;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getEtc() {
		return etc;
	}
	public void setEtc(Date etc) {
		this.etc = etc;
	}
}
