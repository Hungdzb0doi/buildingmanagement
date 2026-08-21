package com.BuildingWeb.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="buildinguser")
public class BuildingUserEntity {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="IdBuildingUser")
private int idBuildingUser;
@ManyToOne
@JoinColumn(name="IdBuilding")
private BuildingEntity building;
@ManyToOne
@JoinColumn(name="IdUser")
private UserEntity user;

    public int getIdBuildingUser() {
        return idBuildingUser;
    }

    public void setIdBuildingUser(int idBuildingUser) {
        this.idBuildingUser = idBuildingUser;
    }

    public BuildingEntity getBuilding() {
        return building;
    }

    public void setBuilding(BuildingEntity building) {
        this.building = building;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
