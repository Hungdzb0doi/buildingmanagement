package com.BuildingWeb.Present;

import com.BuildingWeb.DTO.response.StaffDTO;
import com.BuildingWeb.Service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StaffAPI {
    @Autowired
    private StaffService SS;

    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER','STAFF')")
    @RequestMapping(value = "/api/staff/",method = RequestMethod.GET)
    public List<StaffDTO> FindAllStaff(){
        return SS.FindAllStaff("STAFF");
    }

}
