package com.demo.cc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.demo.cc.dto.UserDto;
import com.demo.cc.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
	
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	User toDto(UserDto userInfo);
	
	UserDto toEntity(User user);

}
