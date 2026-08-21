package com.BuildingWeb.Repository;

import com.BuildingWeb.Entity.BuildingTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingTypeRepository extends JpaRepository<BuildingTypeEntity,Long> {
    void deleteBybuilding_idBuilding(Long idbuilding);
}
