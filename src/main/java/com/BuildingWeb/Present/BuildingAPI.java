package com.BuildingWeb.Present;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BuildingWeb.DTO.BuildingDTO;
import com.BuildingWeb.Service.BuildingService;

@RestController
public class BuildingAPI {
	@Autowired
	BuildingService BS;
@RequestMapping(value="/api/building",method=RequestMethod.GET)
public List<BuildingDTO> FindAll(@RequestParam HashMap<String,Object > params,@RequestParam(value="buildingtype",required=false) List<String> BuildingType) {
	
	return BS.FindAll(params,BuildingType);
}
}
