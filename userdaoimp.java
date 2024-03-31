package com.food.daoimplementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.food.dao.userdao;
import com.food.model.user;


public class userdaoimp implements userdao {
	
private static Connection c=null;
	
	private final static String sqladd="insert into user(user_id,user_name,password,email,address,role)values(?,?,?,?,?,?)";
	 private final static String sqldelete="delete from user where user_id=?";
	
	 private final static String sqlupdate="update user set user_name=?,password=?,email=?,address=?,role=? where user_id=?";
	 private final static String sqldisplay="select * from user where user_id=?";
	 private final static String sqldisplayall="select * from user";
	 private final static String sqlname="select * from user where user_name=?";
	
	private static PreparedStatement st=null;
	private static Statement create=null;
	private static ResultSet res=null;
	
	
	public userdaoimp(){
		
	
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
	public void adduser(user u) {
		try {
			st = c.prepareStatement(sqladd);

			st.setInt(1, u.getUser_id());
			st.setString(2,u.getUser_name());
			st.setString(3,u.getPassword());
			st.setString(4,u.getEmail());
			st.setString(5,u.getAddress());
			st.setString(6,u.getRole());
			st.executeUpdate();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
            
		
	}

	@Override
	public void deleteuser(int user_id) {
		try {
			st=c.prepareStatement(sqldelete);
			st.setInt(1,user_id);
			st.executeUpdate();
			
			
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
	}

	@Override
	public void updateuser(user u) {
		try {
			st=c.prepareStatement(sqlupdate);
			st.setString(1,u.getUser_name());
			st.setString(2,u.getPassword());
			st.setString(3,u.getEmail());
			st.setString(4,u.getAddress());
			st.setString(5,u.getRole());
			st.setInt(6, u.getUser_id());
			st.executeUpdate();
			
			
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		
		
		
	}

	@Override
	public user getuser(int user_id) {
		try {
			st=c.prepareStatement(sqldisplay);
			
			st.setInt(1, user_id);
			res= st.executeQuery();	
			if(res.next())
			{

				int idd=res.getInt("user_id");
				String name=res.getString("user_name");
				String pass=res.getString("password");
				String email=res.getString("email");
				String add=res.getString("address");
				String role=res.getString("role");
				
				user i=new user(idd,name,pass,email,add,role);
				return i;
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		return null;
	}

	@Override
	public List<user> getalluser() {

		ArrayList<user> E=new ArrayList<user>();
		
		try {
			create=c.createStatement();
			res=create.executeQuery(sqldisplayall);
			while(res.next())
			{
				int idd=res.getInt("user_id");
				String name=res.getString("user_name");
				String pass=res.getString("password");
				String email=res.getString("email");
				String add=res.getString("address");
				String role=res.getString("role");
				user i=new user(idd,name,pass,email,add,role);
				E.add(i);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return E;
	
		
	}




	public static  user getUser_name(String user_name) {
		try {
			st=c.prepareStatement(sqlname);
			
			st.setString(1, user_name);
			res= st.executeQuery();	
			if(res.next())
			{

				int idd=res.getInt("user_id");
				String name=res.getString("user_name");
				String pass=res.getString("password");
				String email=res.getString("email");
				String add=res.getString("address");
				String role=res.getString("role");
				
				user i=new user(idd,name,pass,email,add,role);
				return i;
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		return null;
	}
	}








