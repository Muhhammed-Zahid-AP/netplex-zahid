package com.food.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.model.restaurent;
import com.food.model.user;
import com.food.dao.restaurentdao;
import com.food.daoimplementation.orderdaoimp;
import com.food.daoimplementation.restaurentdaoimp;
import com.food.daoimplementation.userdaoimp;

@WebServlet("/home")
public class homeservlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
    	restaurentdaoimp object = new restaurentdaoimp();

        List<restaurent> res = object.getallrestaurent();
        
        
          req.setAttribute("restList", res); 
          RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
          rd.forward(req, resp); 
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    	userdaoimp object = new userdaoimp();

        List<user> res = object.getalluser();
        
        
          req.setAttribute("username", res); 
          RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
          rd.forward(req, resp); 
    }
}
