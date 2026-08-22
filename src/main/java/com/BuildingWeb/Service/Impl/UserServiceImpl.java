package com.BuildingWeb.Service.Impl;

import com.BuildingWeb.DTO.response.UserDTO;
import com.BuildingWeb.Entity.UserEntity;
import com.BuildingWeb.Repository.UserRepository;
import com.BuildingWeb.Repository.UserRoleRepository;
import com.BuildingWeb.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<UserDTO> getAllUser(String userName,String phone){
        String UserName = SecurityContextHolder.getContext().getAuthentication().getName();
        List<UserEntity> userEntities = userRepository.searchUsers(userName, phone);
        return userEntities.stream()
                .filter(userEntity -> !userEntity.getPhone().equals(UserName))
                .map(userEntity -> {
                    UserDTO userDTO = modelMapper.map(userEntity, UserDTO.class);
                    userDTO.setRoles(userRoleRepository.findByuser_idUser(userDTO.getIdUser())
                            .stream()
                            .map(userRoleEntity -> userRoleEntity.getRole().getCode())
                            .collect(Collectors.toList()));
                    return userDTO;
                })
                .collect(Collectors.toList());
    }


}
