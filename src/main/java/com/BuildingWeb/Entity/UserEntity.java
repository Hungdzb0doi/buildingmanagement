package com.BuildingWeb.Entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="user")
public class UserEntity {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="IdUser")
private long idUser;
@Column(name="UserName")
private String userName;
@Column(name="Password")
private String password;
@Column(name="Email")
private String email;
@Column(name="Phone")
private String phone;
@Column(name = "ResetPasswordOtp")
private String resetPasswordOtp;
@Column(name = "OtpTime")
private LocalDateTime otpTime;
@OneToMany(mappedBy="user",fetch=FetchType.LAZY)
private List<AssignmentCustomerEntity> assigmentCustomer=new ArrayList<>();
@OneToMany(mappedBy = "user",fetch=FetchType.LAZY)
private List<UserRoleEntity> userRole=new ArrayList<>();
@OneToMany(mappedBy = "user",fetch=FetchType.LAZY)
private List<TransactionEntity> transaction=new ArrayList<>();
@OneToMany(mappedBy = "user",fetch=FetchType.LAZY)
private List<BuildingUserEntity> buildingUser=new ArrayList<>();

    public String getResetPasswordOtp() {
        return resetPasswordOtp;
    }

    public void setResetPasswordOtp(String resetPasswordOtp) {
        this.resetPasswordOtp = resetPasswordOtp;
    }

    public LocalDateTime getOtpTime() {
        return otpTime;
    }

    public void setOtpTime(LocalDateTime otpTime) {
        this.otpTime = otpTime;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<AssignmentCustomerEntity> getAssigmentCustomer() {
        return assigmentCustomer;
    }

    public void setAssigmentCustomer(List<AssignmentCustomerEntity> assigmentCustomer) {
        this.assigmentCustomer = assigmentCustomer;
    }

    public List<UserRoleEntity> getUserRole() {
        return userRole;
    }

    public void setUserRole(List<UserRoleEntity> userRole) {
        this.userRole = userRole;
    }

    public List<TransactionEntity> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<TransactionEntity> transaction) {
        this.transaction = transaction;
    }

    public List<BuildingUserEntity> getBuildingUser() {
        return buildingUser;
    }

    public void setBuildingUser(List<BuildingUserEntity> buildinguser) {
        this.buildingUser = buildinguser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

