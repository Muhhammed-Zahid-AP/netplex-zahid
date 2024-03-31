package com.food.dao;



import java.util.List;

import com.food.model.order_item;


public interface order_itemdao {
	
	
	

	void addorder_item(order_item o_i);
 void  deleteorder_item(int order_item_id);
	void updateorder_item(order_item o_i );
	order_item getorder_item(int order_item_id);
    List<order_item>getallorder_item(int order_id);

}
