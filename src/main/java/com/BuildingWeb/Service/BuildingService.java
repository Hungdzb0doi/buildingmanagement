package com.BuildingWeb.Service;

import java.util.HashMap;
import java.util.List;

import com.BuildingWeb.DTO.BuildingDTO;
import com.BuildingWeb.DTO.RequestBuildingDTO;

public interface BuildingService {
List<BuildingDTO> FindAll(HashMap<String,Object> params,List<String> BuildingType);
void InsertBuilding(RequestBuildingDTO requestbuildingdto);
void UpdateBuilding(RequestBuildingDTO requestbuildingdto);
void DeleteBuilding(int id);
}
