package com.demo.cc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.demo.cc.model.User;

@Repository
public class UserDao {

	@Autowired
	UserRepository userRepository;
	
	public User saveUser(User user) {
		User userFromDb = userRepository.save(user);
		return userFromDb;
	}
	
}
