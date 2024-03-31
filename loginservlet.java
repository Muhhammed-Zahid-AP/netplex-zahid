package com.food.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.daoimplementation.userdaoimp;
import com.food.model.user;
@WebServlet("/login")
public class loginservlet extends HttpServlet {
	
	
	public void init(){
		
		userdaoimp userdaoimp= new userdaoimp();
	}
     @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String name = req.getParameter("name");
    	String password = req.getParameter("pass");
    	
    	user user=userdaoimp.getUser_name(name);
    	
    	if(user!=null && user.getPassword().equals(password)) {
    		
    		 HttpSession session = req.getSession();
    		 session.setAttribute("loggedinuser", user);
    		 resp.sendRedirect("signup.jsp");
    	}
    	else {
    		
    		req.setAttribute("errorMessage", "invalid username or password");
    		req.getRequestDispatcher("login.jsp").forward(req, resp);
    	}
    	 
    	 
    	 
    	 
    }
}
