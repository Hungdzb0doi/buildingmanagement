package com.BuildingWeb.Present;

import com.BuildingWeb.DTO.request.RequestBuildingUserDTO;
import com.BuildingWeb.Service.BuildingUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BuildingUserAPI {
    @Autowired
    private BuildingUserService BUS;

    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    @GetMapping(value = "api/buildinguser/{id}")
    public List<Long> findIdUserByIdBuilding(@PathVariable Long id){
        return BUS.findIdUserByIdBuilding(id);
    }
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    @PostMapping(value = "api/buildinguser/")
    public void InsertBuildingUser(@RequestBody RequestBuildingUserDTO requestBuildingUserDTO){
        BUS.InsertBuildingUser(requestBuildingUserDTO);
    }
}
