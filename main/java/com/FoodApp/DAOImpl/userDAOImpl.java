package com.FoodApp.DAOImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.FoodApp.DAO.userDAO;
import com.FoodApp.Model.user;
import com.FoodApp.dbutils.DBUtils;

public class userDAOImpl implements userDAO {
	private static String url  ="jdbc:mysql://localhost:3306/app";
	private static String username = "root";
	private static String password = "root@dk";

	private PreparedStatement pstmt;
	private ResultSet res;
	private List<user> userList = new ArrayList<>();
	private Connection con;
	private static final String insert_user = "insert into user (username,password,email,phone,address) values(?,?,?,?,?)";
	
	 
    public userDAOImpl()
    {
    	try{
    		con = DBUtils.myConnect();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
	 

	@Override
	public int insertUser(user user) {
		int x = -1;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
			pstmt = con.prepareStatement(insert_user);
			//   pstmt.setInt(1, user.getUserid());
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getPhone());
			pstmt.setString(5, user.getAddress());
			//   pstmt.setString(7, user.getRole());
			x = pstmt.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return x;
	}

	@Override
	public List<user> getAllUsers() {
		List<user> userList = new ArrayList<>();
		try {
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery("select * from user");
			while (res.next()) {
				user u = new user(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7));
				userList.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public user getUserById(int id) {
		user u = null;
		try {
			pstmt = con.prepareStatement("select * from user where userid = ?");
			pstmt.setInt(1, id);
			res = pstmt.executeQuery();
			if (res.next()) {
				u = new user(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	@Override
	public user getUserByEmail(String email) {
	    user u = null;
	    try {
	        pstmt = con.prepareStatement("select * from user where email = ?");
	        pstmt.setString(1, email);
	        res = pstmt.executeQuery();
	        if (res.next()) {
	            u = new user(res.getInt("userid"), res.getString("username"), res.getString("password"), res.getString("email"), res.getString("phone"), res.getString("address"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return u;
	}


	@Override
	public int deleteUserById(int id) {
		int x = -1;
		try {
			pstmt = con.prepareStatement("delete from user where userid = ?");
			pstmt.setInt(1, id);
			x = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return x;
	}

	@Override
	public int updateUserById(int id, String address) {
		int x = -1;
		try {
			pstmt = con.prepareStatement("update user set address = ? where userid = ?");
			pstmt.setString(1, address);
			pstmt.setInt(2, id);
			x = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return x;
	}
}
