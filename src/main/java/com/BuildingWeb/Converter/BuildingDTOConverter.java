package com.BuildingWeb.Converter;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.BuildingWeb.DTO.response.BuildingDTO;
import com.BuildingWeb.Entity.BuildingEntity;

@Component
public class BuildingDTOConverter {
	
	@Autowired
	ModelMapper modelmapper;
public BuildingDTO ToBuildingDTO(BuildingEntity bett) {
	BuildingDTO bdto=modelmapper.map(bett, BuildingDTO.class);

	String RentArea=bett.getRentArea().stream().map(raett -> String.valueOf(raett.getArea())).collect(Collectors.joining(","));

    bdto.setRentArea(RentArea);

	bdto.setAddress(bett.getWay()+"-"+bett.getWard()+"-"+bett.getDistrict().getDistrictName());
	return bdto;
}
}
