package com.demo.cc.service;

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
		User user = userMapper.toDto(userDto);
		
		User saveUser = userDao.saveUser(user);
		
		return userMapper.toEntity(saveUser);
	}

}
