package com.BuildingWeb.Present;

import com.BuildingWeb.DTO.request.RequestLoginDTO;
import com.BuildingWeb.DTO.request.RequestRegisterDTO;
import com.BuildingWeb.DTO.response.JwtResponse;
import com.BuildingWeb.Exception.ErrorCode;
import com.BuildingWeb.Service.AuthService;
import com.BuildingWeb.Utils.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthAPI {
    private final AuthService authService;
    @PostMapping("/register")
    public ResponseEntity<ApiResponse<Object>> register(@Valid @RequestBody RequestRegisterDTO requestRegisterDTO){
        authService.Register(requestRegisterDTO);
        return ResponseEntity.status(201).body(ApiResponse.created(null));
    }
    @PostMapping("/login")
    public ResponseEntity<ApiResponse<Object>> login(@Valid @RequestBody RequestLoginDTO requestLoginDTO){
        JwtResponse token =authService.Login(requestLoginDTO);
        if(token!=null){
        return ResponseEntity.ok(ApiResponse.success(token));
        }else {
            return ResponseEntity.status(401).body(ApiResponse.error(ErrorCode.UNAUTHENTICATED.getCode(), ErrorCode.UNAUTHENTICATED.getMessage()));
        }
    }

}
