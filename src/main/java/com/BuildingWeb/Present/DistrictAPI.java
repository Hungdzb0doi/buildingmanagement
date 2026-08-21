package com.BuildingWeb.Present;

import com.BuildingWeb.DTO.response.DistrictDTO;
import com.BuildingWeb.Service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DistrictAPI {
    @Autowired
    DistrictService DS;

    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER', 'STAFF')")
    @RequestMapping(value = "/api/district",method = RequestMethod.GET)
    public List<DistrictDTO> findAll(){
        return DS.FindAll();
    }
}
