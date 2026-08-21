package com.BuildingWeb.Service.Impl;

import com.BuildingWeb.DTO.response.DistrictDTO;
import com.BuildingWeb.Entity.DistrictEntity;
import com.BuildingWeb.Repository.DistrictRepository;
import com.BuildingWeb.Service.DistrictService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    DistrictRepository DR;
    @Autowired
    ModelMapper modelMapper;
    public List<DistrictDTO> FindAll()
    {
        List<DistrictDTO> List= new ArrayList<>() ;
        List<DistrictEntity> dett=DR.findAll();
        for(DistrictEntity d:dett){
            List.add(modelMapper.map(d,DistrictDTO.class));
        }
        return List;
    }
}
