package com.BuildingWeb.Service;

import com.BuildingWeb.DTO.request.RequestLoginDTO;
import com.BuildingWeb.DTO.request.RequestRegisterDTO;
import com.BuildingWeb.DTO.response.JwtResponse;

public interface AuthService {
    void Register(RequestRegisterDTO requestRegisterDTO);
    JwtResponse Login(RequestLoginDTO requestLoginDTO);
}
