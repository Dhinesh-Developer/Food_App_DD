

package com.FoodApp.DAOImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.FoodApp.DAO.restaurantDAO;
import com.FoodApp.Model.restaurant;

public class restaurantDAOImpl implements restaurantDAO{
	private static Connection con;
	private static final String insert_Query = "INSERT INTO restaurant (restaurantId, restaurantName, address, phone, rating, eta, imagePath) VALUES(?, ?, ?, ?, ?, ?, ?)";
	private static final String get_res_By_id = "SELECT * FROM restaurant WHERE restaurantId = ?";  
	private static final String delete_By_Id= "delete from restaurant where restaurantId = ?";
	private static final String update_By_id = "update restaurant set restaurantName = ?, restaurantId  =?";
/*
 * 	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "root", "root@dk");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
 */

	private PreparedStatement pstmt;
	private restaurant restaurant;
	@Override
	public int insertRestaurant(restaurant restaurant) {
		int x = -1;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "root", "root@dk");
			pstmt = con.prepareStatement(insert_Query);
			pstmt.setInt(1, restaurant.getRestaurantId());
			pstmt.setString(2, restaurant.getRestaurantName());
			pstmt.setString(3, restaurant.getAddress());
			pstmt.setString(4, restaurant.getPhone());
			pstmt.setString(5, restaurant.getRating());
			pstmt.setString(6, restaurant.getEta());
			pstmt.setString(7, restaurant.getImagepath());

			x = pstmt.executeUpdate();  // Execute the INSERT statement

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return x;  // Return the number of rows affected
	}

	@Override


	public restaurant getRestaurantById(int id) {
		try {
			pstmt = con.prepareStatement(get_res_By_id);
			pstmt.setInt(1, id);
			ResultSet res = pstmt.executeQuery();  // Use executeQuery for SELECT statements

			if (res.next()) {  // Check if the result exists
				restaurant = new restaurant(res.getInt("restaurantId"),
						res.getString("restaurantName"),
						res.getString("address"),
						res.getString("phone"),
						res.getString("rating"),
						res.getString("eta"),
						res.getString("imagePath"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return restaurant;  // Return the restaurant object
	}

	@Override
	public int deleteRestaurantById(int id) {
		int x =-1;
		try {
			pstmt = con.prepareStatement(delete_By_Id);
			pstmt.setInt(1, id);
			x = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return x;
	}


	List<restaurant> extractUserFromResultSet(ResultSet res) {
		List<restaurant> restaurantList = new ArrayList<>();  // Initialize the list

		try {
			while (res.next()) {
				restaurantList.add(new restaurant(res.getInt("restaurantId"),
						res.getString("restaurantName"),
						res.getString("address"),
						res.getString("phone"),
						res.getString("rating"),
						res.getString("eta"),
						res.getString("imagePath")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return restaurantList;
	}



	@Override
	public int updateRestaurantById(int id, String resturantName) {
		int x =-1;
		try {
			pstmt = con.prepareStatement(update_By_id);
			pstmt.setInt(1, id);
			pstmt.setString(2,resturantName);
			x = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int updateRestaurantById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<com.FoodApp.Model.restaurant> getAllrestaurant() {
		// TODO Auto-generated method stub
		return null;
	}



}
