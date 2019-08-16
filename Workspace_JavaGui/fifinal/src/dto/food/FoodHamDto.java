package dto.food;

import java.util.Date;

public class FoodHamDto {
	private String name;
	private int price;
	private Date etc;
	
	public FoodHamDto() {
		
	}
	public FoodHamDto(String name, int price, Date etc) {
		this.name = name;
		this.price = price;
		this.etc = etc;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getEtc() {
		return etc;
	}
	public void setEtc(Date etc) {
		this.etc = etc;
	}
	
}
