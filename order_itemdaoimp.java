package com.food.daoimplementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.food.dao.order_itemdao;
import com.food.model.order_item;
import com.food.model.user;

public class order_itemdaoimp implements order_itemdao {
private static Connection c=null;
	
	private final static String sqladd="insert into order_item(order_item_id,order_id,menu_id,quantity,item_total)values(?,?,?,?,?)";
	 private final static String sqldelete="delete from order_item where order_item_id=?";
	
	 private final static String sqlupdate="update order_item set quantity=?,item_total=? where order_item_id=? and order_id=? and menu_id=?";
	 private final static String sqldisplay="select * from order_item where order_item_id=?";
	 private final static String sqldisplayall="select * from order_item";
	
	private static PreparedStatement st=null;
	private static Statement create=null;
	private static ResultSet res=null;
	
	public order_itemdaoimp(){
		
		
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
	public void addorder_item(order_item o_i) {
		try {
			st = c.prepareStatement(sqladd);

			st.setInt(1, o_i.getOrder_item_id());
			st.setInt(2,o_i.getOrder_id());
			st.setInt(3,o_i.getMenu_id());
			st.setInt(4,o_i.getQuantity());
			st.setDouble(5,o_i.getItem_total());
			
			st.executeUpdate();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
	}

	@Override
	public void deleteorder_item(int order_item_id) {
		try {
			st=c.prepareStatement(sqldelete);
			st.setInt(1,order_item_id);
			st.executeUpdate();
			
			
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateorder_item(order_item o_i) {
        try {
        	st=c.prepareStatement(sqlupdate);
			
        	st.setInt(1,o_i.getQuantity());
			st.setDouble(2,o_i.getItem_total());
			st.setInt(3, o_i.getOrder_item_id());
			st.setInt(4,o_i.getOrder_id());
			st.setInt(5,o_i.getMenu_id());
			st.executeUpdate();
			
			
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	@Override
	public order_item getorder_item(int order_item_id) {
		try {
			st=c.prepareStatement(sqldisplay);
			
			st.setInt(1, order_item_id);
			res= st.executeQuery();	
			if(res.next())
			{

				int idd=res.getInt("order_item_id");
				int iddd=res.getInt("order_id");
				int idddd=res.getInt("menu_id");
				int quantity=res.getInt("quantity");
				double total=res.getDouble("item_total");
				
				
				order_item i=new order_item (idd,iddd,idddd,quantity,total);
				return i;
				
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<order_item> getallorder_item(int order_id) {
ArrayList<order_item> E=new ArrayList<order_item>();
		
		try {
			create=c.createStatement();
			res=create.executeQuery(sqldisplayall);
			while(res.next())
			{
				int idd=res.getInt("order_item_id");
				int iddd=res.getInt("order_id");
				int idddd=res.getInt("menu_id");
				int quantity=res.getInt("quantity");
				double total=res.getDouble("item_total");
				
				
				order_item i=new order_item (idd,iddd,idddd,quantity,total);
				E.add(i);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return E;
		
	}

}