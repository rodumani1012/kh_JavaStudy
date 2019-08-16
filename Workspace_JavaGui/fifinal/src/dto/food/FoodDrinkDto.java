package dto.food;

import java.util.Date;

public class FoodDrinkDto {
	private String name;
	private int price;
	private Date etc;
	
	public FoodDrinkDto() {
		
	}
	public FoodDrinkDto(String name, int price, Date etc) {
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
	public void setPrice(int i) {
		this.price = i;
	}
	public Date getEtc() {
		return etc;
	}
	public void setEtc(Date etc) {
		this.etc = etc;
	}
	
	
}
