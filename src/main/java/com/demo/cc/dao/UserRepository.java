package com.demo.cc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.cc.model.User;


public interface UserRepository extends JpaRepository<User, Integer>{

}
