package com.food.dao;
import java.util.List;


import com.food.model.order;

public interface orderdao {
	void addorder(order o);
	void deleteorder(int order_id);
	void updateorder(order o);
	order getorder(int order_id);
    List<order>getallorder(int user_id);
	
	
	
}
