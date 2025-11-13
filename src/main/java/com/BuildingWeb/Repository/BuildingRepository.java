package com.BuildingWeb.Repository;
import java.util.List;
import com.BuildingWeb.Builder.BuildingSearchBuilder;
import com.BuildingWeb.DTO.RequestBuildingDTO;
import com.BuildingWeb.Entity.BuildingEntity;


public interface BuildingRepository {
List<BuildingEntity> FindAll(BuildingSearchBuilder buildingsearchbuilder);
void InsertBuilding(RequestBuildingDTO requestbuildingdto);
void UpdateBuilding(RequestBuildingDTO requestbuildingdto);
void DeleteBuilding(int id);
}
