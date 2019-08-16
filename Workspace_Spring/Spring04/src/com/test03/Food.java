package com.test03;

public class Food {

	private String foodName;
	private int foodPrice;
	public Food() {
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public void setFoodPrice(int foodPrice) {
		this.foodPrice = foodPrice;
	}
	@Override
	public String toString() {
		return foodName + " : " + foodPrice;
	}
	
}
