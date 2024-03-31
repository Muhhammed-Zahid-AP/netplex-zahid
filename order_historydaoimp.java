package com.food.daoimplementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;



import com.food.dao.order_historydao;
import com.food.model.order_history;
import com.food.model.user;

public class order_historydaoimp implements order_historydao {
	
private static Connection c=null;
	
	private final static String sqladd="insert into order_history(order_history_id,user_id,order_id,order_date,total_amount,status)values(?,?,?,?,?,?)";
	 private final static String sqldelete="delete from order_history where order_history_id=?";
	
	 private final static String sqlupdate="update order_history set order_date=?,total_amount=?,status=? where order_history_id=? and user_id=? and order_id=?";
	 private final static String sqldisplay="select * from order_history where order_history_id=?";
	 private final static String sqldisplayall="select * from order_history";
	
	private static PreparedStatement st=null;
	private static Statement create=null;
	private static ResultSet res=null;

	

	public order_historydaoimp(){
		
	
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
	public void addorder_history(order_history o_h) {
		try {
			st = c.prepareStatement(sqladd);

			st.setInt(1, o_h.getOrder_history_id());
			st.setInt(2,o_h.getUser_id());
			st.setInt(3,o_h.getOrder_id());
			st.setDate(4,o_h.getOrder_date());
			st.setDouble(5,o_h.getTotal_amount());
			st.setBoolean(5,o_h.isStatus());
			st.executeUpdate();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
	}

	@Override
	public void deleteorder_history(int order_history_id) {
		try {
			st=c.prepareStatement(sqldelete);
			st.setInt(1,order_history_id);
			st.executeUpdate();
			
			
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateorder_history(order_history o_h) {
try {
	st=c.prepareStatement(sqlupdate);
			
			st.setDate(1,o_h.getOrder_date());
			st.setDouble(2,o_h.getTotal_amount());
			st.setBoolean(3,o_h.isStatus());
			st.setInt(4,o_h.getOrder_history_id());
			st.setInt(5,o_h.getUser_id());
			st.setInt(6, o_h.getOrder_id());
			st.executeUpdate();
			
			
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	@Override
	public order_history getorder_history(int order_history_id) {
		try {
			st=c.prepareStatement(sqldisplay);
			
			st.setInt(1, order_history_id);
			res= st.executeQuery();	
			if(res.next())
			{

				int idd=res.getInt("order_history_id");
				int iddd=res.getInt("user_id");
				int idddd=res.getInt("order_id");
				Date date=res.getDate("order_date");
				Double amount=res.getDouble("total_amount");
				Boolean status=res.getBoolean("status");
				
				order_history i=new order_history(idd,iddd,idddd,date,amount,status);
				return i;
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<order_history> getallorder_history(int user_id) {
	ArrayList<order_history> E=new ArrayList<order_history>();
		
		try {
			create=c.createStatement();
			res=create.executeQuery(sqldisplayall);
			while(res.next())
			{
				int idd=res.getInt("order_history_id");
				int iddd=res.getInt("user_id");
				int idddd=res.getInt("order_id");
				Date date=res.getDate("order_date");
				Double amount=res.getDouble("total_amount");
				Boolean status=res.getBoolean("status");
				
				order_history i=new order_history(idd,iddd,idddd,date,amount,status);
				E.add(i);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return E;
	}

}
