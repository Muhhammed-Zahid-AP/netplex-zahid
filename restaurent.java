package com.food.model;

public class restaurent {
	private int restaurent_id; 
	private String name ;
	private String cuisine_type; 
	private int delivery_time;  
	private String address  ;
	private int admin_user_id;  
	private double rating ;
	private boolean is_active; 
	private String imagepath;
	public restaurent() {
		
	}
	public restaurent(int restaurent_id, String name, String cuisine_type, int delivery_time, String address,
			int admin_user_id, double rating, boolean is_active, String imagepath) {
		super();
		this.restaurent_id = restaurent_id;
		this.name = name;
		this.cuisine_type = cuisine_type;
		this.delivery_time = delivery_time;
		this.address = address;
		this.admin_user_id = admin_user_id;
		this.rating = rating;
		this.is_active = is_active;
		this.imagepath = imagepath;
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
	public String getCuisine_type() {
		return cuisine_type;
	}
	public void setCuisine_type(String cuisine_type) {
		this.cuisine_type = cuisine_type;
	}
	public int getDelivery_time() {
		return delivery_time;
	}
	public void setDelivery_time(int delivery_time) {
		this.delivery_time = delivery_time;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAdmin_user_id() {
		return admin_user_id;
	}
	public void setAdmin_user_id(int admin_user_id) {
		this.admin_user_id = admin_user_id;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public boolean isIs_active() {
		return is_active;
	}
	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	@Override
	public String toString() {
		return "restaurent [restaurent_id=" + restaurent_id + ", name=" + name + ", cuisine_type=" + cuisine_type
				+ ", delivery_time=" + delivery_time + ", address=" + address + ", admin_user_id=" + admin_user_id
				+ ", rating=" + rating + ", is_active=" + is_active + ", imagepath=" + imagepath + "]";
	}
	
	
}
