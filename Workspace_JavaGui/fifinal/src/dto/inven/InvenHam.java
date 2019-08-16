package dto.inven;

import java.util.Date;

public class InvenHam {
	private String name;
	private int amount;
	private Date etc;
	
	public InvenHam() {
		
	}
	public InvenHam(String name, int amount, Date etc) {
		this.name = name;
		this.amount = amount;
		this.etc = etc;
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
