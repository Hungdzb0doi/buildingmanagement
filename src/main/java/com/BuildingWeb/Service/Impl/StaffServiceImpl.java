package com.BuildingWeb.Service.Impl;

import com.BuildingWeb.DTO.response.StaffDTO;
import com.BuildingWeb.Entity.UserEntity;
import com.BuildingWeb.Repository.StaffRepository;
import com.BuildingWeb.Service.StaffService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffRepository SR;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<StaffDTO> FindAllStaff(String Code) {
        List<StaffDTO> List = new ArrayList<>();
        List<UserEntity> sett = SR.findByuserRole_role_code(Code);

        for(UserEntity s:sett){
            List.add(modelMapper.map(s,StaffDTO.class));
        }
        return List;
    }

}
