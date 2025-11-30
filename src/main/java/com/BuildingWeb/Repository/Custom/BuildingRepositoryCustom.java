package com.BuildingWeb.Repository.Custom;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.BuildingWeb.Builder.BuildingSearchBuilder;

import com.BuildingWeb.Entity.BuildingEntity;
@Repository
public interface BuildingRepositoryCustom {
	List<BuildingEntity> FindAll(BuildingSearchBuilder buildingsearchbuilder);
	
	
}
