package com.BuildingWeb.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="buildinguser")
public class BuildingUserEntity {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="IdBuildingUser")
private int IdBuildingUser;
@ManyToOne
@JoinColumn(name="IdBuilding")
private BuildingEntity Building;
@ManyToOne
@JoinColumn(name="IdUser")
private UserEntity User;

public int getIdBuildingUser() {
	return IdBuildingUser;
}
public void setIdBuildingUser(int idBuildingUser) {
	IdBuildingUser = idBuildingUser;
}
public BuildingEntity getBuilding() {
	return Building;
}
public void setBuilding(BuildingEntity building) {
	Building = building;
}
public UserEntity getUser() {
	return User;
}
public void setUser(UserEntity user) {
	User = user;
}
}
