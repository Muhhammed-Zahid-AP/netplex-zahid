package com.food.dao;
import java.util.List;

import com.food.model.restaurent;

public interface restaurentdao {
	void addrestaurent(restaurent r);
	void deleterestaurent(int restaurent_id);
	void updaterestaurent(restaurent r);
	restaurent getrestaurent(int restaurent_id);
    List<restaurent>getallrestaurent();
}
