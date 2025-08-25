package com.demo.cc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.cc.model.User;


public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findByUserNameLike(String name);//select * from user where name =?
	
	User findByUserNameAndEmail(String name,String email);//select * from user where name = ? and email = ?
	
	User findByUserNameOrEmail(String name,String email);// select * from user where name = ? or email = ?

}
