package com.food.model;

public class cartitem {
	
	private int order_item_id;
	private int restaurent_id;
	private String name;
	private int quantity;
	private double price;
	
	
	
	
	
	
	public cartitem() {
		
	}
	public cartitem(int order_item_id, int restaurent_id, String name, int quantity, double price) {
		super();
		this.order_item_id = order_item_id;
		this.restaurent_id = restaurent_id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	public int getOrder_item_id() {
		return order_item_id;
	}
	public void setOrder_item_id(int order_item_id) {
		this.order_item_id = order_item_id;
	}
	public int getRestaurent_id() {
		return restaurent_id;
	}
	public void setRestaurent_id(int restaurent_id) {
		this.restaurent_id = restaurent_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "cartitem [order_item_id=" + order_item_id + ", restaurent_id=" + restaurent_id + ", name=" + name
				+ ", quantity=" + quantity + ", price=" + price + "]";
	}
	
	
	

}
