package com.food.model;

public class menu {
	
	private int menu_id ;
	private int restaurent_id; 
	private String item_name ;
	private String description ;
	private double price ;
	private boolean is_available;
	public menu() {

		
		
		
	}
	public menu(int menu_id, int restaurent_id, String item_name, String description, double price,
			boolean is_available) {
		super();
		this.menu_id = menu_id;
		this.restaurent_id = restaurent_id;
		this.item_name = item_name;
		this.description = description;
		this.price = price;
		this.is_available = is_available;
	}
	public int getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}
	public int getRestaurent_id() {
		return restaurent_id;
	}
	public void setRestaurent_id(int restaurent_id) {
		this.restaurent_id = restaurent_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isIs_available() {
		return is_available;
	}
	public void setIs_available(boolean is_available) {
		this.is_available = is_available;
	}
	@Override
	public String toString() {
		return "menu [menu_id=" + menu_id + ", restaurent_id=" + restaurent_id + ", item_name=" + item_name
				+ ", description=" + description + ", price=" + price + ", is_available=" + is_available + "]";
	}
	
	
	

}
