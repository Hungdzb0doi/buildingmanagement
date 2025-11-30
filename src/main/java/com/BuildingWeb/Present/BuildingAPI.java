package com.BuildingWeb.Present;


import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BuildingWeb.DTO.BuildingDTO;
import com.BuildingWeb.DTO.RequestBuildingDTO;

import com.BuildingWeb.Service.BuildingService;

@RestController

public class BuildingAPI {
	@Autowired
	BuildingService BS;
	
	
@RequestMapping(value="/api/building",method=RequestMethod.GET)
public List<BuildingDTO> FindAll(@RequestParam HashMap<String,Object > params,@RequestParam(value="buildingtype",required=false) List<String> BuildingType) {
	
	return BS.FindAll(params, BuildingType);
}

@RequestMapping(value="/api/building",method=RequestMethod.POST)
public void InsertBuilding(@RequestBody RequestBuildingDTO requestbuildingdto){
	BS.InsertBuilding(requestbuildingdto);
}
@RequestMapping(value="/api/building{id}",method=RequestMethod.DELETE)
public void DeleteBuilding(@PathVariable Long[] id) {
	BS.DeleteBuildings(id);
}
@RequestMapping(value="/api/building",method=RequestMethod.PUT)
public void UpdateBuilding(@RequestBody RequestBuildingDTO requestbuildingdto) {
	BS.UpdateBuilding(requestbuildingdto);
}
}
