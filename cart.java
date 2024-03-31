package com.food.model;

import java.util.HashMap;
import java.util.Map;
import com.food.model.cartitem;


public class cart {

	
	private Map<Integer,cartitem> items;
	
	
		
		 
		 public cart() {
			 this.items=new HashMap<>();
		 }
		
	
	public  void additem(cartitem item){
		 int itemid = item.getOrder_item_id();
		 if(items.containsKey(itemid))
		 {
		cartitem existingitem=items.get(itemid);
		existingitem.setQuantity(existingitem.getQuantity()+ item.getQuantity());
		items.put(itemid, item);
		 }
		 
		 else
		 {
			 items.put(itemid, item);
		 }
		
	 }
	 
	 
	 
	 
	 
	 public void updateitem(int order_item_id,int quantity){
		 
		 if(items.containsKey(order_item_id));
		 {
			 if(quantity <=0)
			 {
				 items.remove(order_item_id);
			 }
			 else {
				 items.get(order_item_id).setQuantity(quantity);
			 }
		 }
		 
		 
		 
		 
	 }
	public  void removeitem(int order_item_id){
		 
		 
		 items.remove(order_item_id);
		 
	 }
	public  Map<Integer, cartitem> getItems(){
		 
		 return items;
		 
	 }
	 public void clear(){
		 items.clear();
	 }
	
	
	
	
}
