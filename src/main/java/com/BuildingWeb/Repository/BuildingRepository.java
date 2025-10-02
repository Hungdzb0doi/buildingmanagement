package com.BuildingWeb.Repository;

import java.util.HashMap;
import java.util.List;

import com.BuildingWeb.Entity.BuildingEntity;


public interface BuildingRepository {
List<BuildingEntity> FindAll(HashMap<String,Object> params,List<String> BuildingType);

}
