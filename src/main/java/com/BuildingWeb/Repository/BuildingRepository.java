package com.BuildingWeb.Repository;


import org.springframework.data.jpa.repository.JpaRepository;


import com.BuildingWeb.Entity.BuildingEntity;
import com.BuildingWeb.Repository.Custom.BuildingRepositoryCustom;


public interface BuildingRepository extends JpaRepository<BuildingEntity,Long>,BuildingRepositoryCustom {

	void deleteByIdBuildingIn(Long[] id);

}
