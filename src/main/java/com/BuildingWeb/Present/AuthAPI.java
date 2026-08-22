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
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/forgotpassword")
    public ResponseEntity<ApiResponse<Object>> forgotPassword(@RequestParam String email){
        authService.generateAndSendOtp(email);
        return ResponseEntity.ok(ApiResponse.created(null));
    }
    @PostMapping("/resetpassword")
    public ResponseEntity<ApiResponse<Object>> resetPassword(
            @RequestParam String email,
            @RequestParam String otp,
            @RequestParam String newPassword){
        authService.resetPassword(email,otp,newPassword);
        return ResponseEntity.ok(ApiResponse.created(null));
    }

}
