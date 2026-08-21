package com.BuildingWeb.Service.Impl;

import com.BuildingWeb.DTO.request.RequestUserRoleDTO;
import com.BuildingWeb.Entity.RoleEntity;
import com.BuildingWeb.Entity.UserEntity;
import com.BuildingWeb.Entity.UserRoleEntity;
import com.BuildingWeb.Repository.RoleRepository;
import com.BuildingWeb.Repository.UserRepository;
import com.BuildingWeb.Repository.UserRoleRepository;
import com.BuildingWeb.Service.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleRepository userRoleRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    @Override
    public void insertUserRole(RequestUserRoleDTO requestUserRoleDTO) {
        userRoleRepository.deleteByuser_idUser(requestUserRoleDTO.getIdUser());
        if(requestUserRoleDTO.getIdRole()!=null&&!requestUserRoleDTO.getIdRole().isEmpty()) {
            UserEntity userEntity = userRepository.findById(requestUserRoleDTO.getIdUser()).get();
            for(Long idRole : requestUserRoleDTO.getIdRole()) {
                RoleEntity roleEntity = roleRepository.findById(idRole).get();
                UserRoleEntity userRoleEntity = new UserRoleEntity();
                userRoleEntity.setUser(userEntity);
                userRoleEntity.setRole(roleEntity);
                userRoleRepository.save(userRoleEntity);
            }
        }
    }
}
