package com.food.dao;

import java.util.List;

import com.food.model.order_history;

public interface order_historydao {
	
	
	
	void addorder_history(order_history o_h);
	void deleteorder_history(int order_history_id);
	void updateorder_history(order_history o_h );
	order_history getorder_history(int order_history_id);
    List<order_history>getallorder_history(int user_id);

}




