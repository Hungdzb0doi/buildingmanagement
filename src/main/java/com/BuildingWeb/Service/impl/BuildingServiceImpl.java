package com.BuildingWeb.Service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BuildingWeb.Converter.BuildingDTOConverter;
import com.BuildingWeb.DTO.BuildingDTO;
import com.BuildingWeb.Entity.BuildingEntity;
import com.BuildingWeb.Repository.BuildingRepository;
import com.BuildingWeb.Service.BuildingService;
@Service
public class BuildingServiceImpl implements BuildingService {
	@Autowired
	BuildingRepository BR;
	@Autowired
	BuildingDTOConverter BDTOC;
	@Override
public List<BuildingDTO> FindAll(HashMap<String,Object> params,List<String> BuildingType){
	List<BuildingEntity> RequestBuildingEntity=BR.FindAll(params,BuildingType);
	List<BuildingDTO> ListBuilding =new ArrayList<>();
	
	for(BuildingEntity bett : RequestBuildingEntity) {
	    
		ListBuilding.add(BDTOC.ToBuildingDTO(bett));
		}
	
		
	

	return ListBuilding.stream().distinct().collect(Collectors.toList());
}
}
