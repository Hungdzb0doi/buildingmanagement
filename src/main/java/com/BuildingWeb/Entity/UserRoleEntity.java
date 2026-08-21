package com.BuildingWeb.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="userrole")
public class UserRoleEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="IdUserRole")
    private int idUserRole;
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name="IdUser")
private UserEntity user;
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name="IdRole")
private RoleEntity role;

    public int getIdUserRole() {
        return idUserRole;
    }

    public void setIdUserRole(int idUserRole) {
        this.idUserRole = idUserRole;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }
}
