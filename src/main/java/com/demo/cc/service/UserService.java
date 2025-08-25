package com.demo.cc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.cc.dao.UserDao;
import com.demo.cc.dto.UserDto;
import com.demo.cc.mapper.UserMapper;
import com.demo.cc.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserDao userDao;
	
	public UserDto saveUser(UserDto userDto) {
		User user = userMapper.toEntity(userDto);
		
		User saveUser = userDao.saveUser(user);
		
		return userMapper.toDto(saveUser);
	}
	
	public UserDto getUserById(Integer id) {
		Optional<User> optional = userDao.getUserById(id);
		UserDto userDto = null;
		if (optional.isPresent()) {
			 userDto = userMapper.toDto(optional.get());
		}
		return userDto;
	}

	public UserDto getUserByName(String name) {
		User userByName = userDao.getUserByName(name);
		UserDto userDto = null;
		if (userByName != null) {
			 userDto = userMapper.toDto(userByName);
		}
		return userDto;
	}

}
