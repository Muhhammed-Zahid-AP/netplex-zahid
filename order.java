package com.food.model;

import java.sql.Date;

public class order {
	private int order_id;  
	private int user_id  ;
	private int restaurent_id;  
	private Date order_date  ;
	private double total_amount ;
	private String status ;
	private String payment_method;
	public order() {
		
	}
	public order(int order_id, int user_id, int restaurent_id, Date order_date, double total_amount, String status,
			String payment_method) {
		super();
		this.order_id = order_id;
		this.user_id = user_id;
		this.restaurent_id = restaurent_id;
		this.order_date = order_date;
		this.total_amount = total_amount;
		this.status = status;
		this.payment_method = payment_method;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getRestaurent_id() {
		return restaurent_id;
	}
	public void setRestaurent_id(int restaurent_id) {
		this.restaurent_id = restaurent_id;
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
	public String isStatus() {
		return status;
	}
	public void setStatus(String string) {
		this.status = string;
	}
	public String getPayment_method() {
		return payment_method;
	}
	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}
	@Override
	public String toString() {
		return "order [order_id=" + order_id + ", user_id=" + user_id + ", restaurent_id=" + restaurent_id
				+ ", order_date=" + order_date + ", total_amount=" + total_amount + ", status=" + status
				+ ", payment_method=" + payment_method + "]";
	}
	
	

}
