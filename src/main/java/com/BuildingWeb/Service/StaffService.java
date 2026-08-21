package com.BuildingWeb.Service;

import com.BuildingWeb.DTO.response.StaffDTO;

import java.util.List;

public interface StaffService {
    public List<StaffDTO> FindAllStaff(String Code);

}
