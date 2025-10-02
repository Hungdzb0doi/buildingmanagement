package com.BuildingWeb.Entity;

public class BuildingTypeEntity {
private int IdBuildingType;
private String Code;
private String BuildingTypeName;
private String Note;
private int IdBuilding;
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
public int getIdBuilding() {
	return IdBuilding;
}
public void setIdBuilding(int idBuilding) {
	IdBuilding = idBuilding;
}
}


