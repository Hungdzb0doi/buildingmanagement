package com.BuildingWeb.Service.Impl;

import com.BuildingWeb.DTO.response.RoleDTO;
import com.BuildingWeb.Entity.RoleEntity;
import com.BuildingWeb.Repository.RoleRepository;
import com.BuildingWeb.Service.RoleService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    public List<RoleDTO> getAllRole() {
        List<RoleEntity> roleEntities = roleRepository.findAll();
        return roleEntities.stream().map(roleEntity -> modelMapper.map(roleEntity, RoleDTO.class)).collect(Collectors.toList());
    }
}
