package com.FoodApp.DAO;

import java.util.List;

import com.FoodApp.Model.menu;

public interface menuDAO {
	
	int insertMenu(com.FoodApp.Servlets.menu m);
	List<menu> getAllmenu();
	menu getMenuById(int id);
	int deleteMenuById(int id);
	int updateMenuById(int id);
	int updateMenuById(int id, String itemName);
	int updateMenuById(int id, int price);


}
