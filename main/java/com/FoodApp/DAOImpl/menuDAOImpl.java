package com.FoodApp.DAOImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.FoodApp.DAO.menuDAO;
import com.FoodApp.Model.menu;
import com.FoodApp.Model.user;

public class menuDAOImpl implements menuDAO {

	private static String url  ="jdbc:mysql://localhost:3306/app";
	private static String username = "root";
	private static String password = "root@dk";

	private PreparedStatement pstmt;
	private ResultSet res;
	private List<user> userList = new ArrayList<>();
	private Connection con;
	private Statement st;
	private static final String insert_menu= "insert into menu (restaurantId,itemName,price,ratings,isAvailable) values(?.?,?,?,?,?)";



	@Override
	public int insertMenu(menu menu) {
		int x = -1;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = 	DriverManager.getConnection(url, username, password);
			pstmt = con.prepareStatement(insert_menu);
			//pstmt.setInt(1, menu.getMenuId());
			pstmt.setInt(1, menu.getRestaurantId());
			pstmt.setString(2, menu.getItemName());
			pstmt.setInt(3, menu.getPrice());
			pstmt.setString(4, menu.getRatings());
			pstmt.setString(5, menu.getIsAvailable());

			x = pstmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return x;
	}

	@Override
	public List<menu> getAllmenu() {
		List<menu> menu = new ArrayList<>();
		try {
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery("select * from menu");
			while (res.next()) {
				menu m = new menu(res.getInt(1), res.getInt(2), res.getString(3), res.getInt(4), res.getString(5), res.getString(6));
				menu.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menu;		
	}

	@Override
	public menu getMenuById(int id) {
		menu m = null;
		try {
			pstmt = con.prepareStatement("select * from menu where menuId = ?");
			pstmt.setInt(1, id);
			res = pstmt.executeQuery();
			if (res.next()) {
				m = new menu(res.getInt(1),res.getInt(2), res.getString(3), res.getInt(4), res.getString(5), res.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;
	}

	@Override
	public int deleteMenuById(int id) {
		int x = -1;
		try {
			pstmt = con.prepareStatement("delete from menu where menuId = ?");
			pstmt.setInt(1, id);
			x = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return x;
	}

	@Override
	public int updateMenuById(int id, int price) {
		int x = -1;
		try {
			pstmt = con.prepareStatement("update menu set price = ? where menuId = ?");
			pstmt.setInt(1,price );
			pstmt.setInt(2, id);
			x = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return x;
	}

	@Override
	public int updateMenuById(int id, String itemName) {
		int x = -1;
		try {
			pstmt = con.prepareStatement("update menu set itemName = ? where menuId = ?");
			pstmt.setString(1,itemName );
			pstmt.setInt(2, id);
			x = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return x;
	}



}
