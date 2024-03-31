package com.food.servlets;

import java.io.IOException;

import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.dao.orderdao;
import com.food.daoimplementation.orderdaoimp;
import com.food.model.cart;
import com.food.model.cartitem;
import com.food.model.order;

@WebServlet("/checkout")
public class checkoutserlet extends HttpServlet {

	
	private orderdao orderdao;
	
	
	public void init() {
		
		 orderdao= new orderdaoimp();
		
	}
	
	
	
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


HttpSession session = req.getSession();
cart cart =(cart) session.getAttribute("cart");



if(cart != null  && !cart.getItems().isEmpty()) {
	
	String paymentmethod = req.getParameter("paymentmethod");
	
	
	order order = new order();
order.setOrder_date(new Date(System.currentTimeMillis()));
	order.setPayment_method(paymentmethod);
	order.setStatus("pending");
	
	double totalamount=0;
	for(cartitem item:cart.getItems().values()) {
		totalamount=totalamount+item.getPrice()*item.getQuantity();
	}
	order.setTotal_amount(totalamount);
	
	orderdao.addorder(order);
	session.removeAttribute("cart");
	session.setAttribute("order", order);
	resp.sendRedirect("order_confirm.jsp");
}
else {
	resp.sendRedirect("additem.jsp");
}
	
	
	
	
	
}





}










