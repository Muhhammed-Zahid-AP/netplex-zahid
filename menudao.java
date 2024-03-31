package com.food.dao;
import java.util.List;

import com.food.model.menu;


public interface menudao {
	void addmenu(menu m );
	void deletemenu(int menu_id);
	void updatemenu(menu m);
	menu getmenu(int menu_id);
    List<menu>getallmenu(int restaurent_id);
}
