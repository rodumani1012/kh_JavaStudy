package com.test03;

public class MyFoodMgr {

	private Food favoriteFood;
	private Food unfavoriteFood;
	
	public MyFoodMgr() {
		Food food = new Food();
		food.setFoodName("삼겹살");
		food.setFoodPrice(8000);
		this.favoriteFood = food;
	}
	
	public MyFoodMgr(Food favoriteFood, Food unfavoriteFood) {
		this.favoriteFood = favoriteFood;
		this.unfavoriteFood = unfavoriteFood;
	}

	public Food getFavoriteFood() {
		return favoriteFood;
	}

	public void setFavoriteFood(Food favoriteFood) {
		this.favoriteFood = favoriteFood;
	}

	public Food getUnfavoriteFood() {
		return unfavoriteFood;
	}

	public void setUnfavoriteFood(Food unfavoriteFood) {
		this.unfavoriteFood = unfavoriteFood;
	}

	@Override
	public String toString() {
		return "좋아 = " + favoriteFood + "\t 싫어 = " + unfavoriteFood;
	}
	
	
}
