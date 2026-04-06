package com.BuildingWeb.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="role")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="IdRole")
private int IdRole;
    @Column(name="Code")
private String Code;
    @Column(name="RoleName")
private String RoleName;
    @OneToMany(mappedBy = "Role", fetch = FetchType.LAZY)
private List<UserRoleEntity> UserRole=new ArrayList<UserRoleEntity>();
public int getIdRole() {
	return IdRole;
}
public void setIdRole(int idRole) {
	IdRole = idRole;
}
public String getCode() {
	return Code;
}
public void setCode(String code) {
	Code = code;
}
public String getRoleName() {
	return RoleName;
}
public void setRoleName(String roleName) {
	RoleName = roleName;
}

    public List<UserRoleEntity> getUserRole() {
        return UserRole;
    }

    public void setUserRole(List<UserRoleEntity> userRole) {
        UserRole = userRole;
    }
}

