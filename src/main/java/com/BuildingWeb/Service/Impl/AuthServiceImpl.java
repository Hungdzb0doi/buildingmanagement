package com.BuildingWeb.Service.Impl;



import com.BuildingWeb.DTO.request.RequestLoginDTO;
import com.BuildingWeb.DTO.request.RequestRegisterDTO;
import com.BuildingWeb.DTO.response.JwtResponse;
import com.BuildingWeb.Entity.UserEntity;
import com.BuildingWeb.Entity.UserRoleEntity;
import com.BuildingWeb.Exception.AppException;
import com.BuildingWeb.Exception.ErrorCode;
import com.BuildingWeb.Repository.RoleRepository;
import com.BuildingWeb.Repository.UserRepository;
import com.BuildingWeb.Repository.UserRoleRepository;
import com.BuildingWeb.Service.AuthService;


import com.BuildingWeb.Service.Impl.Security.CustomUserDetailsService;
import com.BuildingWeb.Service.Impl.Security.JwtService;
import org.modelmapper.ModelMapper;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthServiceImpl implements AuthService {
    private final UserRoleRepository userRoleRepository;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    @Override
    public void Register(RequestRegisterDTO requestRegisterDTO) {

        if (userRepository.existsByphone(requestRegisterDTO.getPhone())) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }


        UserEntity newUser = new UserEntity();
        modelMapper.map(requestRegisterDTO, newUser);


        String encodedPassword = passwordEncoder.encode(requestRegisterDTO.getPassword());
        newUser.setPassword(encodedPassword);

        UserRoleEntity userRoleEntity = new UserRoleEntity();
        userRoleEntity.setRole(roleRepository.findBycode("STAFF"));
        userRoleEntity.setUser(newUser);
        userRoleRepository.save(userRoleEntity);


        userRepository.save(newUser);


    }
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService customUserDetailsService;
    @Override
    public JwtResponse Login(RequestLoginDTO requestLoginDTO) {
        Authentication authentication=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(requestLoginDTO.getUsername()
                ,requestLoginDTO.getPassword())
        );
        UserDetails user = (UserDetails) authentication.getPrincipal();
        String jwtToken = jwtService.generateToken(user);

        return JwtResponse.builder()
                .token(jwtToken)
                .roles(user.getAuthorities().stream().map(auth -> auth.getAuthority()).toList())

                .build();
    }
    private final JavaMailSender mailSender;
    @Override
    public void generateAndSendOtp(String email){
        UserEntity userEntity = userRepository.findByemail(email).orElseThrow(() -> new RuntimeException("User not found with email: " + email));

        userEntity.setResetPasswordOtp(String.format("%06d",new Random().nextInt(999999)));
        userEntity.setOtpTime(LocalDateTime.now().plusMinutes(5));
        userRepository.save(userEntity);

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(email);
        mailMessage.setSubject("Your OTP for Password Reset");
        mailMessage.setText("Your OTP is: " + userEntity.getResetPasswordOtp());
        mailSender.send(mailMessage);

    }
    @Override
    public void resetPassword(String email, String otp, String newPassword){
        UserEntity userEntity = userRepository.findByemail(email).orElseThrow(() -> new RuntimeException("User not found with email: " + email));
        if(!userEntity.getResetPasswordOtp().equals(otp)){
            throw new RuntimeException("Invalid OTP");
        }
        if(userEntity.getOtpTime().isBefore(LocalDateTime.now())){
            throw new RuntimeException("OTP has expired");
        }
        userEntity.setPassword(passwordEncoder.encode(newPassword));
        userEntity.setResetPasswordOtp(null);
        userEntity.setOtpTime(null);
        userRepository.save(userEntity);
    }
}
