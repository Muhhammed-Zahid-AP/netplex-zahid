package com.food.model;

import java.sql.Date;

public class order_history {
	private int order_history_id ; 
	private int user_id  ;
	private int order_id  ;
	private Date order_date ; 
	private double total_amount;  
	private boolean status ;
	public order_history() {
		
	}
	public order_history(int order_history_id, int user_id, int order_id, Date order_date, double total_amount,
			boolean status) {
		super();
		this.order_history_id = order_history_id;
		this.user_id = user_id;
		this.order_id = order_id;
		this.order_date = order_date;
		this.total_amount = total_amount;
		this.status = status;
	}
	public int getOrder_history_id() {
		return order_history_id;
	}
	public void setOrder_history_id(int order_history_id) {
		this.order_history_id = order_history_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public double getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "order_history [order_history_id=" + order_history_id + ", user_id=" + user_id + ", order_id=" + order_id
				+ ", order_date=" + order_date + ", total_amount=" + total_amount + ", status=" + status + "]";
	}
	
	
	
}
