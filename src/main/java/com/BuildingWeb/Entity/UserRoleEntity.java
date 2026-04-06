package com.BuildingWeb.Entity;

import javax.persistence.*;

@Entity
@Table(name="userrole")
public class UserRoleEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="IdUserRole")
    private int IdUserRole;
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name="IdUser")
private UserEntity User;
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name="IdRole")
private RoleEntity Role;
    public RoleEntity getRole() {
        return Role;
    }

    public void setRole(RoleEntity role) {
        Role = role;
    }

    public UserEntity getUser() {
        return User;
    }

    public void setUser(UserEntity user) {
        User = user;
    }

    public int getIdUserRole() {
        return IdUserRole;
    }

    public void setIdUserRole(int idUserRole) {
        IdUserRole = idUserRole;
    }


}
