package com.BuildingWeb.Present;

import com.BuildingWeb.DTO.request.RequestUserRoleDTO;
import com.BuildingWeb.DTO.response.UserDTO;
import com.BuildingWeb.Service.UserRoleService;
import com.BuildingWeb.Service.UserService;
import com.BuildingWeb.Utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserAPI {
    private final UserService userService;
    private final UserRoleService userRoleService;
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    @GetMapping
    public ResponseEntity<ApiResponse<Object>> getUser(@RequestParam(value = "userName",required = false) String userName,@RequestParam(value = "phone",required = false) String phone){
        List<UserDTO> users = userService.getAllUser(userName, phone);
        return ResponseEntity.ok(ApiResponse.success(users));
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<ApiResponse<Object>> assignRole(@RequestBody RequestUserRoleDTO requestUserRoleDTO){
        userRoleService.insertUserRole(requestUserRoleDTO);
        return ResponseEntity.ok(ApiResponse.success(null));
    }
}
