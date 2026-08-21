package com.BuildingWeb.Repository;

import com.BuildingWeb.Entity.RentAreaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentAreaRepository extends JpaRepository<RentAreaEntity,Long> {
    void deleteBybuilding_idBuilding(Long idbuilding);
}
