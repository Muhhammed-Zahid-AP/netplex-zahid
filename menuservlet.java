package com.food.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.daoimplementation.menudaoimp;
import com.food.model.menu;
@WebServlet("/Menu")

public class menuservlet extends HttpServlet{
	
	
	private menudaoimp menudao;
	
	
	public void init() {
		
		menudao=new menudaoimp();
		
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String para = req.getParameter("restaurent_id");
		if(para !=null) {
			try {
				
				List<menu> res=menudao.getallmenu(Integer.parseInt(para));
				req.setAttribute("menulist", res);
				
			}
			catch(NumberFormatException e) {
				
			}
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("menu.jsp");
		rd.forward(req, resp);
		
		
		
		
		
	}

}
