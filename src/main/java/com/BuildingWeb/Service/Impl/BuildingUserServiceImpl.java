package com.BuildingWeb.Service.Impl;

import com.BuildingWeb.DTO.request.RequestBuildingUserDTO;
import com.BuildingWeb.Entity.BuildingEntity;
import com.BuildingWeb.Entity.BuildingUserEntity;
import com.BuildingWeb.Entity.UserEntity;
import com.BuildingWeb.Repository.BuildingRepository;
import com.BuildingWeb.Repository.BuildingUserRepository;
import com.BuildingWeb.Repository.StaffRepository;
import com.BuildingWeb.Service.BuildingUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
public class BuildingUserServiceImpl implements BuildingUserService {
    @Autowired
    private BuildingUserRepository BUR;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private BuildingRepository BR;
    @Autowired
    private StaffRepository SR;
    @Override
    public List<Long> findIdUserByIdBuilding(Long IdBuilding) {
        return BUR.findIdUserByIdBuilding(IdBuilding);
    }
    public void InsertBuildingUser(RequestBuildingUserDTO requestBuildingUserDTO) {
        BUR.deleteBybuilding_idBuilding(requestBuildingUserDTO.getIdBuilding());
        if(requestBuildingUserDTO.getIdUser()!=null&&!requestBuildingUserDTO.getIdUser().isEmpty()) {
            BuildingEntity buildingEntity = BR.findById(requestBuildingUserDTO.getIdBuilding()).get();
            for(Long idUser : requestBuildingUserDTO.getIdUser()) {
            UserEntity userEntity = SR.findById(idUser).get();
            BuildingUserEntity buildingUserEntity = new BuildingUserEntity();
            buildingUserEntity.setUser(userEntity);
            buildingUserEntity.setBuilding(buildingEntity);
            BUR.save(buildingUserEntity);
        }
        }

    }
}
