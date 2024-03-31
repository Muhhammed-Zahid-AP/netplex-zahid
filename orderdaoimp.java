package com.food.daoimplementation;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.food.dao.orderdao;
import com.food.model.order;
import com.food.model.user;


public class orderdaoimp implements orderdao {
	
	
	private static Connection c=null;
	private final static String sqladd="insert into order(order_id,user_id,restaurent_id,order_date,total_amount,status,payment_method)values(?,?,?,?,?,?,?)";
	 private final static String sqldelete="delete from order where order_id=?";
	
	 private final static String sqlupdate="update order set order_date=?,total_amount=?,status=?,payment_method=? where order_id=? and user_id=? and restaurent_id=?";
	 private final static String sqldisplay="select * from order where order_id=?";
	 private final static String sqldisplayall="select * from order where user_id=?";
	
	private static PreparedStatement st=null;
	private static Statement create=null;
	private static ResultSet res=null;
	
	public orderdaoimp(){
		
		
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		 try {
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/fooddeliveryapp","root","root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	@Override
	public void addorder(order o) {
	
		try {
			st = c.prepareStatement(sqladd);

			st.setInt(1, o.getOrder_id());
			st.setInt(2,o.getUser_id());
			st.setInt(3,o.getRestaurent_id());
			st.setDate(4,o.getOrder_date());
			st.setDouble(5,o.getTotal_amount());
			st.setString(6,o.isStatus());
			st.setString(7,o.getPayment_method());
			st.executeUpdate();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
	}

	@Override
	public void deleteorder(int order_id) {
		try {
			st=c.prepareStatement(sqldelete);
			st.setInt(1,order_id);
			st.executeUpdate();
			
			
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateorder(order o) {
	try {
		st=c.prepareStatement(sqlupdate);
		st.setDate(1,o.getOrder_date());
		st.setDouble(2,o.getTotal_amount());
		st.setString(3,o.isStatus());
		st.setString(4,o.getPayment_method());
		st.setInt(5, o.getOrder_id());
		st.setInt(6,o.getUser_id());
		st.setInt(7,o.getRestaurent_id());
			
			st.executeUpdate();
			
			
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	@Override
	public order getorder(int order_id) {
		try {
			st=c.prepareStatement(sqldisplay);
			
			st.setInt(1, order_id);
			res= st.executeQuery();	
			if(res.next())
			{

				int idd=res.getInt("order_id");
				int iddd=res.getInt("user_id");
				int idddd=res.getInt("restaurent_id");
				Date date=res.getDate("order_date");
				Double total=res.getDouble("total_amount");
				String status=res.getString("status");
				String payment=res.getString("payment_method");
				
				order i=new order(idd,iddd,idddd,date,total,status,payment);
				return i;
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<order> getallorder(int user_id) {
		
ArrayList<order> E=new ArrayList<order>();
		
		try {
			create=c.createStatement();
			res=create.executeQuery(sqldisplayall);
			while(res.next())
			{
				int idd=res.getInt("order_id");
				int iddd=res.getInt("user_id");
				int idddd=res.getInt("restaurent_id");
				Date date=res.getDate("order_date");
				Double total=res.getDouble("total_amount");
				String status=res.getString("status");
				String payment=res.getString("payment_method");
				
				order i=new order(idd,iddd,idddd,date,total,status,payment);
				E.add(i);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return E;
	}

}
