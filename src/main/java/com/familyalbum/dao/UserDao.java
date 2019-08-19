package com.familyalbum.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.familyalbum.model.User;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
	
	List<User> findAll();
	
	User findByUserName(String userName);
	
	User findByUserId(Long userId);
	
	User save(User user);

}
