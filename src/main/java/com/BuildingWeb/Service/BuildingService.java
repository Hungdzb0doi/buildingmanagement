package com.BuildingWeb.Service;

import java.util.HashMap;
import java.util.List;

import com.BuildingWeb.DTO.BuildingDTO;

public interface BuildingService {
List<BuildingDTO> FindAll(HashMap<String,Object> params,List<String> BuildingType);
}
