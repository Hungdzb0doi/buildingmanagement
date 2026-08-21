package com.BuildingWeb.Entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="role")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="IdRole")
private int idRole;
    @Column(name="Code")
private String code;
    @Column(name="RoleName")
private String roleName;
    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
private List<UserRoleEntity> UserRole=new ArrayList<UserRoleEntity>();

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<UserRoleEntity> getUserRole() {
        return UserRole;
    }

    public void setUserRole(List<UserRoleEntity> userRole) {
        UserRole = userRole;
    }
}

