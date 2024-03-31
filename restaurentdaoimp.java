package com.food.daoimplementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.food.dao.restaurentdao;
import com.food.model.restaurent;
import com.food.model.user;

public class restaurentdaoimp implements restaurentdao {
private static Connection c=null;
	
	private final static String sqladd="insert into restaurent(restaurent_id,name,cuisine_type,delivery_time,address,admin_user_id,rating,is_active,imagepath)values(?,?,?,?,?,?,?,?,?)";
	 private final static String sqldelete="delete from restaurent where restaurent_id=?";
	
	 private final static String sqlupdate="update restaurent set name=?,cuisine_type=?,deliver_time=?,address=?,rating=?,is_active=?,imagepath=? where restaurent_id=? and admin_user_id=?";
	 private final static String sqldisplay="select * from restaurent where restaurent_id=?";
	 private final static String sqldisplayall="select * from restaurent ";
	
	private static PreparedStatement st=null;
	private static Statement create=null;
	private static ResultSet res=null;
	
	
	public restaurentdaoimp(){
		
	
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
	public void addrestaurent(restaurent r) {
		
		try {
			st = c.prepareStatement(sqladd);

			st.setInt(1, r.getRestaurent_id());
			st.setString(2,r.getName());
			st.setString(3,r.getCuisine_type());
			st.setInt(4,r.getDelivery_time());
			st.setString(5,r.getAddress());
			st.setInt(6,r.getAdmin_user_id());
			st.setDouble(7,r.getRating());
			st.setBoolean(8,r.isIs_active());
			st.setString(9,r.getImagepath());
			st.executeUpdate();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
	}

	@Override
	public void deleterestaurent(int restaurent_id) {
		try {
			st=c.prepareStatement(sqldelete);
			st.setInt(1,restaurent_id);
			 st.executeUpdate();
			
			
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	
	}

	@Override
	public void updaterestaurent(restaurent r) {
		try {
			st=c.prepareStatement(sqlupdate);
			st.setString(1,r.getName());
			st.setString(2,r.getCuisine_type());
			st.setInt(3,r.getDelivery_time());
			st.setString(4,r.getAddress());
			st.setDouble(5,r.getRating());
			st.setBoolean(6,r.isIs_active());
			st.setString(7,r.getImagepath());
			st.setInt(8, r.getRestaurent_id());
			st.setInt(9,r.getAdmin_user_id());
			
			st.executeUpdate();
			
			
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	@Override
	public restaurent getrestaurent(int restaurent_id) {
		try {
			st=c.prepareStatement(sqldisplay);
			
			st.setInt(1, restaurent_id);
			res= st.executeQuery();	
			if(res.next())
			{

				int idd=res.getInt("restaurent_id");
				String name=res.getString("name");
				String type=res.getString("cuisine_type");
				int time=res.getInt("delivery_time");
				String address=res.getString("address");
				int iddd=res.getInt("admin_user_id");
				Double rating=res.getDouble("rating");
			    Boolean active=res.getBoolean("is_active");
				String image=res.getString("imagepath");
				
				 restaurent i=new restaurent(idd,name,type,time,address,iddd,rating,active,image);
				return i;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}

	@Override
	public List<restaurent> getallrestaurent() {
ArrayList<restaurent> E=new ArrayList<restaurent>();
		
		try {
			create=c.createStatement();
			res=create.executeQuery(sqldisplayall);
			while(res.next())
			{
				int idd=res.getInt("restaurent_id");
				String name=res.getString("name");
				String type=res.getString("cuisine_type");
				int time=res.getInt("delivery_time");
				String address=res.getString("address");
				int iddd=res.getInt("admin_user_id");
				Double rating=res.getDouble("rating");
			    Boolean active=res.getBoolean("is_active");
				String image=res.getString("imagepath");
				restaurent i=new restaurent(idd,name,type,time,address,iddd,rating,active,image);
				E.add(i);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return E;
	
	}

}
