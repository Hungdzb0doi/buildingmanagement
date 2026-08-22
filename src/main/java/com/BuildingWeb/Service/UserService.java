package com.BuildingWeb.Service;

import com.BuildingWeb.DTO.response.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUser(String userName,String phone);

}
