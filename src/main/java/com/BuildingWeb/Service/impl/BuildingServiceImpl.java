package com.BuildingWeb.Service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BuildingWeb.Builder.BuildingSearchBuilder;
import com.BuildingWeb.Converter.BuildingDTOConverter;
import com.BuildingWeb.Converter.BuildingSearchBuilderConverter;
import com.BuildingWeb.DTO.BuildingDTO;
import com.BuildingWeb.DTO.RequestBuildingDTO;
import com.BuildingWeb.Entity.BuildingEntity;
import com.BuildingWeb.Entity.DistrictEntity;
import com.BuildingWeb.Repository.BuildingRepository;
import com.BuildingWeb.Repository.DistrictRepository;
import com.BuildingWeb.Service.BuildingService;
@Service
@Transactional
public class BuildingServiceImpl implements BuildingService {
	@Autowired
	BuildingRepository BR;
	@Autowired
	DistrictRepository DR;
	@Autowired
	BuildingDTOConverter BDTOC;
	@Autowired
	BuildingSearchBuilderConverter BSBC;
	@Autowired
	ModelMapper modelmapper;
	@Override
public List<BuildingDTO> FindAll(HashMap<String,Object> params,List<String> BuildingType){
	BuildingSearchBuilder buildingsearchbuilder=	BSBC.ToBuildingSearchBuilder(params, BuildingType);
	List<BuildingEntity> RequestBuildingEntity= BR.FindAll(buildingsearchbuilder);
	List<BuildingDTO> ListBuilding =new ArrayList<>();
	
	for(BuildingEntity bett : RequestBuildingEntity) {
	    
		ListBuilding.add(BDTOC.ToBuildingDTO(bett));
		}
	
		
	
	
	return ListBuilding.stream().distinct().collect(Collectors.toList());
}
	
	public void InsertBuilding(RequestBuildingDTO requestbuildingdto) {
		BuildingEntity buildingentity=modelmapper.map(requestbuildingdto, BuildingEntity.class);
		DistrictEntity districtentity= new DistrictEntity();
		districtentity.setIdDistrict((long) requestbuildingdto.getIdDistrict());
		buildingentity.setDistrict(districtentity);
		BR.save(buildingentity);
	}
	public void UpdateBuilding(RequestBuildingDTO requestbuildingdto) {
		BuildingEntity buildingentity=BR.findById(requestbuildingdto.getIdBuilding()).get();
		BeanUtils.copyProperties(requestbuildingdto, buildingentity,"District");
		DistrictEntity districtentity= DR.findById((long) requestbuildingdto.getIdDistrict()).get();
		buildingentity.setDistrict(districtentity);
		BR.save(buildingentity);
	}
	public void DeleteBuilding(Long id) {
		BR.deleteById(id);;
	}
	public void DeleteBuildings(Long[] id) {
		BR.deleteByIdBuildingIn(id);;
	}
}
