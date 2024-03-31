package com.food.daoimplementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.food.dao.menudao;
import com.food.model.menu;


public class menudaoimp implements menudao {
	
private static Connection c=null;
	
	private final static String sqladd="insert into menu(menu_id,restaurent_id,item_name,description,price,is_available)values(?,?,?,?,?,?)";
	 private final static String sqldelete="delete from user where menu_id=?";
	
	 private final static String sqlupdate="update menu set item_name=?,description=?,price=?,is_available=? where menu_id=? and restaurent_id=?";
	 private final static String sqldisplay="select * from menu where menu_id=?";
	 private final static String sqldisplayall="select * from menu where restaurent_id=?";
	
	private static PreparedStatement st=null;
	private static Statement create=null;
	private static ResultSet res=null;
	
	
	public menudaoimp(){
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 try {
				c=DriverManager.getConnection("jdbc:mysql://localhost:3306/fooddeliveryapp","root","root");
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		}
	
	

	@Override
	public void addmenu(menu m) {
		try {
			st = c.prepareStatement(sqladd);

			st.setInt(1, m.getMenu_id());
			st.setInt(2,m.getRestaurent_id());
			st.setString(3,m.getItem_name());
			st.setString(4,m.getDescription());
			st.setDouble(5,m.getPrice());
			st.setBoolean(6,m.isIs_available());
			st.executeUpdate();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
            
		
	}
		
	

	@Override
	public void deletemenu(int menu_id) {
		
		try {
			st=c.prepareStatement(sqldelete);
			st.setInt(1,menu_id);
			st.executeUpdate();
			
			
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	
	}

	@Override
	public void updatemenu(menu m) {
		try {
			st=c.prepareStatement(sqlupdate);
			st.setString(1,m.getItem_name());
			st.setString(2,m.getDescription());
			st.setDouble(3,m.getPrice());
			st.setBoolean(4,m.isIs_available());
			st.setInt(5, m.getMenu_id());
			st.setInt(6,m.getRestaurent_id());
			st.executeUpdate();
			
			
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	@Override
	public menu getmenu(int menu_id) {
		
		try {
		st=c.prepareStatement(sqldisplay);
		
		st.setInt(1, menu_id);
		res= st.executeQuery();	
		if(res.next())
		{

			
			
			int idd=res.getInt("menu_id");
			int iddd=res.getInt("restaurent_id");
			String name=res.getString("item_name");
			String des=res.getString("description");
			Double price=res.getDouble("price");
			Boolean avail=res.getBoolean("is_available");
			
			
			menu i=new menu(idd,iddd,name,des,price,avail);
			return i;
			
		}
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	
	
	return null;
}


	@Override
	public List<menu> getallmenu(int restaurent_id) {
    List<menu> E=new ArrayList<>();
		
		try {
			st=c.prepareStatement(sqldisplayall);
			
			
			st.setInt(1, restaurent_id);
			try(ResultSet res=st.executeQuery()){
				
				while(res.next())
				{
				
				menu menu=extractmenufromrestaurent(res);
				E.add(menu);
			}
			
				
				
	            
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return E;
	
	}



	private menu extractmenufromrestaurent(ResultSet res) throws SQLException {
		menu menu=new menu();
		menu.setMenu_id(res.getInt("menu_id"));
		menu.setRestaurent_id(res.getInt("restaurent_id"));
		menu.setItem_name(res.getString("item_name"));
		menu.setDescription(res.getString("description"));
		menu.setPrice(res.getDouble("price"));
		menu.setIs_available(res.getBoolean("is_available"));
		return menu;
		
	}
	
	
	

}
