package com.BuildingWeb.Service.Impl.Security;

import com.BuildingWeb.Entity.UserEntity;
import com.BuildingWeb.Exception.AppException;
import com.BuildingWeb.Exception.ErrorCode;
import com.BuildingWeb.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    public UserDetails loadUserByUsername(String phone) {
        UserEntity userEntity=userRepository.findByphone(phone).orElseThrow(()->new AppException(ErrorCode.USER_NOT_EXISTED));
        List<SimpleGrantedAuthority> authorities = userEntity.getUserRole().stream().map(role -> new SimpleGrantedAuthority("ROLE_"+role.getRole().getCode())).collect(Collectors.toList());
        return new CustomUserDetails(userEntity, authorities);
    }
}
