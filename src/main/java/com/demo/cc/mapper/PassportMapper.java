package com.demo.cc.mapper;

import org.mapstruct.Mapper;

import com.demo.cc.dto.PassportDetailsDto;
import com.demo.cc.model.PassportDetails;

@Mapper(componentModel = "spring")
public interface PassportMapper {

	PassportDetails toEntity(PassportDetailsDto passportDetailsDto);
}
