package com.demo.cc.mapper;

import org.mapstruct.Mapper;

import com.demo.cc.dto.AddressDto;
import com.demo.cc.model.Address;

@Mapper(componentModel = "spring")
public interface AddressMapper {
	Address toEntity(AddressDto addressDto);
	
	AddressDto toDto(Address address);
}
