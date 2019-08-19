package com.familyalbum.service;

import java.util.List;

import com.familyalbum.model.User;

public interface UserService {
	
	List<User> findAllUsers();
	
	User findByUserName(String userName);
	
	User save(User user);

}
