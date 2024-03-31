package com.food.servlets;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.daoimplementation.menudaoimp;
import com.food.model.cart;
import com.food.model.cartitem;
import com.food.model.menu;
import com.food.dao.menudao;
import java.util.Map;
import java.util.HashMap;


@WebServlet("/cartservlet")
public class cartservlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	HttpSession session = request.getSession();
	cart cart = (cart)session.getAttribute("cart");
	
	if(cart == null)
	{
		cart=new cart();
		session.setAttribute("cart", cart);
	}
	
	
	String action= request.getParameter("action");
	
	if(action.equals("add")) {
		additemtocart(request,cart);
	}
	else if(action.equals("update")) {
		updateitemcart(request,cart);
	}
	else if(action.equals("remove")) {
		removeitemfromcart(request,cart);
	}
	
	
	session.setAttribute("cart", cart);
	response.sendRedirect("additem.jsp");
	
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("additem.jsp").forward(request, response);
	}
	
	
	private void additemtocart(HttpServletRequest request, cart cart) {
		
		
		int itemid =Integer.parseInt(request.getParameter("itemid"));
		
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		
		menudaoimp menudaoimp = new menudaoimp();
		
		menu menu = menudaoimp.getmenu(itemid);
		
		HttpSession session = request.getSession();
		session.setAttribute("restaurentid", menu.getRestaurent_id());
		
		if(menu != null) {
			cartitem cartitem = new cartitem(menu.getMenu_id(),menu.getRestaurent_id(),menu.getItem_name(),quantity,menu.getPrice());
			
			cart.additem(cartitem);
		}
		
}
	private void updateitemcart(HttpServletRequest request, cart cart) {
		int itemid =Integer.parseInt( request.getParameter("itemid"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		
		cart.updateitem(itemid,quantity);
		
		
		
	}
	private void removeitemfromcart(HttpServletRequest request, cart cart) {
		int itemid =Integer.parseInt( request.getParameter("itemid"));
		
		cart.removeitem(itemid);
		
		
	}



	
	

	
	 
	

}
