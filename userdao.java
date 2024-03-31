package com.food.dao;
import java.util.List;

import com.food.model.user;

public interface userdao {

	void adduser(user u);
	void deleteuser(int user_id);
	void updateuser(user u);
	user getuser(int user_id);
	List<user>getalluser();
	
	
}
