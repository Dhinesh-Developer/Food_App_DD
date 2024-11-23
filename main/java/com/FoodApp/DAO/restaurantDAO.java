package com.FoodApp.DAO;

import java.util.List;

import com.FoodApp.Model.*;

public interface restaurantDAO {
	int insertRestaurant(restaurant restaurant);
	List<restaurant > getAllrestaurant();
	restaurant getRestaurantById(int id);
	int deleteRestaurantById(int id);
	int updateRestaurantById(int id);
	int updateRestaurantById(int id, String resturantName);

}
