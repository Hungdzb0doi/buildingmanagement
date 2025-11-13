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
@Table(name="buildingtype")
public class BuildingTypeEntity {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="IdBuildingType")
private int IdBuildingType;
@Column(name="Code")
private String Code;
@Column(name="BuildingTypeName")
private String BuildingTypeName;
@Column(name="Note")
private String Note;
@ManyToOne
@JoinColumn(name="IdBuilding")
private BuildingEntity Building;
public BuildingEntity getBuilding() {
	return Building;
}
public void setBuilding(BuildingEntity building) {
	Building = building;
}
public int getIdBuildingType() {
	return IdBuildingType;
}
public void setIdBuildingType(int idBuildingType) {
	IdBuildingType = idBuildingType;
}
public String getCode() {
	return Code;
}
public void setCode(String code) {
	Code = code;
}
public String getBuildingTypeName() {
	return BuildingTypeName;
}
public void setBuildingTypeName(String buildingTypeName) {
	BuildingTypeName = buildingTypeName;
}
public String getNote() {
	return Note;
}
public void setNote(String note) {
	Note = note;
}

}


