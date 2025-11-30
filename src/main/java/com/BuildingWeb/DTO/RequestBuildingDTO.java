package com.BuildingWeb.DTO;


public class RequestBuildingDTO {
private Long IdBuilding;
private String BuildingName;
private String Code;
private String ward;
private String way;
private int IdDistrict;
private int NumberOfBasement;
private String ManagerName;
private String ManagerPhone;
private int FloorArea;
private String RentArea;
private int EmptyArea;
private int Rent;
private String ServiceFee;
private String BrokerageFee;
public Long getIdBuilding() {
	return IdBuilding;
}
public void setIdBuilding(Long idBuilding) {
	IdBuilding =  idBuilding;
}
public String getCode() {
	return Code;
}
public void setCode(String code) {
	Code = code;
}
public String getWard() {
	return ward;
}
public void setWard(String ward) {
	this.ward = ward;
}
public String getWay() {
	return way;
}
public void setWay(String way) {
	this.way = way;
}
public int getIdDistrict() {
	return IdDistrict;
}
public void setIdDistrict(int idDistrict) {
	IdDistrict = idDistrict;
}
public String getBuildingName() {
	return BuildingName;
}
public void setBuildingName(String buildingName) {
	BuildingName = buildingName;
}
public String getRentArea() {
	return RentArea;
}
public void setRentArea(String rentArea) {
	RentArea = rentArea;
}

public int getNumberOfBasement() {
	return NumberOfBasement;
}
public void setNumberOfBasement(int numberOfBasement) {
	NumberOfBasement = numberOfBasement;
}
public String getManagerName() {
	return ManagerName;
}
public void setManagerName(String managerName) {
	ManagerName = managerName;
}
public String getManagerPhone() {
	return ManagerPhone;
}
public void setManagerPhone(String managerPhone) {
	ManagerPhone = managerPhone;
}
public int getFloorArea() {
	return FloorArea;
}
public void setFloorArea(int floorArea) {
	FloorArea = floorArea;
}

public int getEmptyArea() {
	return EmptyArea;
}
public void setEmptyArea(int emptyArea) {
	EmptyArea = emptyArea;
}
public int getRent() {
	return Rent;
}
public void setRent(int rent) {
	Rent = rent;
}
public String getServiceFee() {
	return ServiceFee;
}
public void setServiceFee(String serviceFee) {
	ServiceFee = serviceFee;
}
public String getBrokerageFee() {
	return BrokerageFee;
}
public void setBrokerageFee(String brokerageFee) {
	BrokerageFee = brokerageFee;
}
}

