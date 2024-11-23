package com.FoodApp.Model;

public class restaurant {
	private int restaurantId;
	private String restaurantName;
	private String  address;
	private String phone;
	private String rating;

	private String eta;
	private String imagepath;
	public restaurant(int restaurantId, String restaurantName, String address, String phone, String d,
			String i, String imagepath) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.address = address;
		this.phone = phone;
		this.rating = rating;
		this.eta = i;
		this.imagepath = imagepath;
	}
	
	
 @Override
	public String toString() {
		return "restaurant [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + ", address="
				+ address + ", phone=" + phone + ", rating=" + rating + ", eta=" + eta
				+ ", imagepath=" + imagepath + "]";
	}


public int getRestaurantId() {
		return restaurantId;
	}


	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}


	public String getRestaurantName() {
		return restaurantName;
	}


	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getRating() {
		return rating;
	}


	public void setRating(String rating) {
		this.rating = rating;
	}




	public restaurant(String restaurantName, String address, String phone, String rating, String eta, String imagepath) {
		super();
		this.restaurantName = restaurantName;
		this.address = address;
		this.phone = phone;
		this.rating = rating;
		this.eta = eta;
		this.imagepath = imagepath;
	}


	public String getEta() {
		return eta;
	}




	public String getImagepath() {
		return imagepath;
	}


	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}


public restaurant() {
	// TODO Auto-generated constructor stub
}




}
