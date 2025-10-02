package com.BuildingWeb.Converter;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.BuildingWeb.DTO.BuildingDTO;
import com.BuildingWeb.Entity.BuildingEntity;
import com.BuildingWeb.Entity.RentAreaEntity;
import com.BuildingWeb.Repository.DistrictRepository;
import com.BuildingWeb.Repository.RentAreaRepository;
@Component
public class BuildingDTOConverter {
	@Autowired
	DistrictRepository DR;
	@Autowired
	RentAreaRepository RAR;
	@Autowired
	ModelMapper modelmapper;
public BuildingDTO ToBuildingDTO(BuildingEntity bett) {
	BuildingDTO bdto=modelmapper.map(bett, BuildingDTO.class);
	int sumarea=0;
	String RentArea=RAR.FindRentArea(bett.getIdBuilding()).stream().map(raett -> String.valueOf(raett.getArea())).collect(Collectors.joining(","));
	for(RentAreaEntity raett:RAR.FindRentArea(bett.getIdBuilding())) {
		sumarea+=raett.getArea();
	}
    bdto.setRentArea(RentArea);
    bdto.setEmptyArea(bett.getFloorArea()-sumarea);
	bdto.setAddress(bett.getWay()+"-"+bett.getWard()+"-"+DR.FindDistrict(bett.getIdDistrict()).getDistrictName());
	return bdto;
}
}
