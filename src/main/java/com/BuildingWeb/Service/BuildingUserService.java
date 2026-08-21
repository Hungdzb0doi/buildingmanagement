package com.BuildingWeb.Service;

import com.BuildingWeb.DTO.request.RequestBuildingUserDTO;

import java.util.List;

public interface BuildingUserService {
    List<Long> findIdUserByIdBuilding(Long IdBuilding);
    void InsertBuildingUser(RequestBuildingUserDTO requestBuildingUserDTO);
}
