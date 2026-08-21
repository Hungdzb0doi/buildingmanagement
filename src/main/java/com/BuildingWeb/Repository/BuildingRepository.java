package com.BuildingWeb.Repository;


import org.springframework.data.jpa.repository.JpaRepository;


import com.BuildingWeb.Entity.BuildingEntity;
import com.BuildingWeb.Repository.Custom.BuildingRepositoryCustom;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface BuildingRepository extends JpaRepository<BuildingEntity,Long>,BuildingRepositoryCustom {

	void deleteByIdBuildingIn(Long[] id);

    @Query("SELECT b.district, b.class1, SUM(ra.area) " +
            "FROM BuildingEntity b JOIN b.rentArea ra " +
            "GROUP BY b.district, b.class1 " +
            "ORDER BY b.district ASC, b.class1 ASC")
    List<Object[]> getAvailableAreaByDistrictAndClass();
}
