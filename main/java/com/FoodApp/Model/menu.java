package com.FoodApp.Model;

public class menu {

	private int menuId;
	private int restaurantId;
	private String itemName;
	private int price;
	private String ratings;
	private String isAvailable;
	public menu(int menuId, int restaurantId, String itemName, int price, String ratings, String isAvailable) {
		super();
		this.menuId = menuId;
		this.restaurantId = restaurantId;
		this.itemName = itemName;
		this.price = price;
		this.ratings = ratings;
		this.isAvailable = isAvailable;
	}
	public menu() {
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getRatings() {
		return ratings;
	}
	public void setRatings(String ratings) {
		this.ratings = ratings;
	}
	public String getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}
	@Override
	public String toString() {
		return "menu [menuId=" + menuId + ", restaurantId=" + restaurantId + ", itemName=" + itemName + ", price="
				+ price + ", ratings=" + ratings + ", isAvailable=" + isAvailable + "]";
	}
	public menu(int restaurantId, String itemName, int price, String ratings, String isAvailable) {
		super();
		this.restaurantId = restaurantId;
		this.itemName = itemName;
		this.price = price;
		this.ratings = ratings;
		this.isAvailable = isAvailable;
	}
	public menu(String itemName, int price, String ratings, String isAvailable) {
		super();
		this.itemName = itemName;
		this.price = price;
		this.ratings = ratings;
		this.isAvailable = isAvailable;
	}
	
}
