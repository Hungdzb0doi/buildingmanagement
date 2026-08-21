package com.BuildingWeb.Repository;

import com.BuildingWeb.Entity.BuildingUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BuildingUserRepository extends JpaRepository<BuildingUserEntity,Long> {
   @Query("SELECT b.user.idUser FROM BuildingUserEntity b WHERE b.building.idBuilding= :IdBuilding")
    List<Long> findIdUserByIdBuilding(@Param("IdBuilding") Long IdBuilding);
    void deleteBybuilding_idBuilding( Long IdBuilding);
}
