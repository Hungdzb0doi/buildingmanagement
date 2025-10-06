package com.BuildingWeb.Repository;
import java.util.List;
import com.BuildingWeb.Builder.BuildingSearchBuilder;
import com.BuildingWeb.Entity.BuildingEntity;


public interface BuildingRepository {
List<BuildingEntity> FindAll(BuildingSearchBuilder buildingsearchbuilder);

}
