package com.demo.cc.mapper;

import org.mapstruct.Mapper;

import com.demo.cc.dto.AaadharDetailsDto;
import com.demo.cc.model.AaadharDetails;

@Mapper(componentModel = "spring")
public interface AadharMapper {
	
	AaadharDetails toEntity(AaadharDetailsDto aaadharDetailsDto);
	
	AaadharDetailsDto toDto(AaadharDetails aaadharDetails);

}
