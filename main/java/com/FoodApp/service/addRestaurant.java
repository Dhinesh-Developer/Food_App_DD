package com.FoodApp.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.FoodApp.DAO.restaurantDAO;
import com.FoodApp.DAOImpl.restaurantDAOImpl;
import com.FoodApp.Model.restaurant;


@WebServlet("/restaurantRegister")
public class addRestaurant extends HttpServlet {

	 @Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 
		 int rid = Integer.parseInt(req.getParameter("rid"));
		 String rname = req.getParameter("rname");
		 String address = req.getParameter("address");
		 String phone = req.getParameter("phone");
		 String rating = req.getParameter("rating");
		 String eta = req.getParameter("eta");
		 String imagePath = req.getParameter("imagePath");
		 
	 
	   restaurant r = new restaurant(rid,rname,address,phone,rating,eta,imagePath);
	   
	   restaurantDAO rd = new restaurantDAOImpl();
	   int status = rd.insertRestaurant(r);
	   if(status == 0)
	   {
		   resp.sendRedirect("failure.html");
	   }
	   else
	   {
		   resp.sendRedirect("success.html");
	   }
	 
	 }
}
