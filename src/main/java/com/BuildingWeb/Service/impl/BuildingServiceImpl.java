package com.BuildingWeb.Service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BuildingWeb.Builder.BuildingSearchBuilder;
import com.BuildingWeb.Converter.BuildingDTOConverter;
import com.BuildingWeb.Converter.BuildingSearchBuilderConverter;
import com.BuildingWeb.DTO.BuildingDTO;
import com.BuildingWeb.DTO.RequestBuildingDTO;
import com.BuildingWeb.Entity.BuildingEntity;
import com.BuildingWeb.Repository.BuildingRepository;
import com.BuildingWeb.Service.BuildingService;
@Service
@Transactional
public class BuildingServiceImpl implements BuildingService {
	@Autowired
	BuildingRepository BR;
	@Autowired
	BuildingDTOConverter BDTOC;
	@Autowired
	BuildingSearchBuilderConverter BSBC;
	@Override
public List<BuildingDTO> FindAll(HashMap<String,Object> params,List<String> BuildingType){
	BuildingSearchBuilder buildingsearchbuilder=	BSBC.ToBuildingSearchBuilder(params, BuildingType);
	List<BuildingEntity> RequestBuildingEntity=BR.FindAll( buildingsearchbuilder);
	List<BuildingDTO> ListBuilding =new ArrayList<>();
	
	for(BuildingEntity bett : RequestBuildingEntity) {
	    
		ListBuilding.add(BDTOC.ToBuildingDTO(bett));
		}
	
		
	

	return ListBuilding.stream().distinct().collect(Collectors.toList());
}
	public void InsertBuilding(RequestBuildingDTO requestbuildingdto) {
		BR.InsertBuilding(requestbuildingdto);
	}
	public void UpdateBuilding(RequestBuildingDTO requestbuildingdto) {
		BR.UpdateBuilding(requestbuildingdto);
	}
	public void DeleteBuilding(int id) {
		BR.DeleteBuilding(id);
	}
}
