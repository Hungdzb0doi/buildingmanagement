package com.BuildingWeb.Present;


import java.util.HashMap;
import java.util.List;

import com.BuildingWeb.DTO.response.BuildingStatisticDTO;
import com.BuildingWeb.Utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.BuildingWeb.DTO.response.BuildingDTO;
import com.BuildingWeb.DTO.request.RequestBuildingDTO;

import com.BuildingWeb.Service.BuildingService;

@RestController
public class BuildingAPI {
    @Autowired
    BuildingService BS;


    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER', 'STAFF')")
    @RequestMapping(value = "/api/building/", method = RequestMethod.GET)
    public List<BuildingDTO> FindAll(@RequestParam HashMap<String, Object> params, @RequestParam(value = "buildingtype", required = false) List<String> BuildingType) {

        return BS.FindAll(params, BuildingType);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    @RequestMapping(value = "/api/building/", method = RequestMethod.POST)
    public void InsertBuilding(@RequestBody RequestBuildingDTO requestbuildingdto) {

        BS.InsertBuilding(requestbuildingdto);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    @RequestMapping(value = "/api/building/{id}", method = RequestMethod.DELETE)
    public void DeleteBuilding(@PathVariable Long[] id) {
        BS.DeleteBuildings(id);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    @RequestMapping(value = "/api/building/", method = RequestMethod.PUT)
    public void UpdateBuilding(@RequestBody RequestBuildingDTO requestbuildingdto) {
        BS.UpdateBuilding(requestbuildingdto);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER', 'STAFF')")
    @RequestMapping(value = "/api/building/{id}", method = RequestMethod.GET)
    public RequestBuildingDTO FindById(@PathVariable("id") Long IdBuilding) {

        return BS.FindById(IdBuilding);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    @GetMapping("/api/building/statistic")
    public ResponseEntity<ApiResponse<Object>> getAreaStatistic() {
        List<BuildingStatisticDTO> result = BS.getAvailableAreaStatistic();
        return ResponseEntity.ok(ApiResponse.success(result));
    }
}
