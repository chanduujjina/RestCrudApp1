package com.demo.cc.dao;

import java.util.Optional;

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
	
	public Optional<User> getUserById(Integer id) {
		return userRepository.findById(id);
	}

	public User getUserByName(String name) {
		
		return userRepository.findByUserNameLike(name);
	}
	
}
