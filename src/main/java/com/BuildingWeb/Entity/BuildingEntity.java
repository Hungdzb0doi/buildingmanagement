package com.BuildingWeb.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="building")
public class BuildingEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdBuilding")
	private int IdBuilding;
	@Column(name="Code")
	private String Code;
	@Column(name="BuildingName")
	private String BuildingName;
	@Column(name="Ward")
	private String Ward;
	@Column(name="Way")
	private String Way;
	@Column(name="Structure")
	private String Structure;
	@Column(name="NumberOfBasement")
	private int NumberOfBasement;
	@Column(name="FloorArea")
	private int FloorArea;
	@Column(name="Direction")
	private String Direction;
	@Column(name="Class")
	private String Class1;
	@Column(name="Rent")
	private int Rent;
	@Column(name="DescriptionPrice")
	private String DescriptionPrice;
	@Column(name="MotocycleFee")
	private String MotocycleFee;
	@Column(name="CarFee")
	private String CarFee;
	@Column(name="ServiceFee")
	private String ServiceFee;
	@Column(name="OverTimeFee")
	private String OverTimeFee;
	@Column(name="ElectricityBill")
	private String ElectricityBill;
	@Column(name="Deposit")
	private int Deposit;
	@Column(name="Pay")
	private String Pay;
	@Column(name="LeaseTerm")
	private String LeaseTerm;
	@Column(name="DecorationTime")
	private String DecorationTime;
	@Column(name="ManagerName")
	private String ManagerName;
	@Column(name="ManagerPhone")
	private String ManagerPhone;
	@Column(name="BrokerageFee")
	private String BrokerageFee;
	@Column(name="Note")
	private String Note;
	@ManyToOne
	@JoinColumn(name="IdDistrict")
	private DistrictEntity District;
	@OneToMany(mappedBy="Building",fetch=FetchType.LAZY)
	private List<RentAreaEntity> RentArea=new ArrayList<>();
	@OneToMany(mappedBy="Building",fetch=FetchType.LAZY)
	private List<BuildingUserEntity> BuildingUser=new ArrayList<>(); 
	@OneToMany(mappedBy="Building",fetch=FetchType.LAZY)
	private List<BuildingTypeEntity> BuildingType=new ArrayList<>();
	
	public List<BuildingTypeEntity> getBuildingType() {
		return BuildingType;
	}
	public void setBuildingType(List<BuildingTypeEntity> buildingType) {
		BuildingType = buildingType;
	}
	public List<BuildingUserEntity> getBuildingUser() {
		return BuildingUser;
	}
	public void setBuildingUser(List<BuildingUserEntity> buildingUser) {
		BuildingUser = buildingUser;
	}

	public List<RentAreaEntity> getRentArea() {
		return RentArea;
	}
	public void setRentArea(List<RentAreaEntity> rentArea) {
		RentArea = rentArea;
	}
	public int getIdBuilding() {
		return IdBuilding;
	}
	public void setIdBuilding(int idBuilding) {
		IdBuilding = idBuilding;
	}
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public String getBuildingName() {
		return BuildingName;
	}
	public void setBuildingName(String buildingName) {
		BuildingName = buildingName;
	}
	public String getWard() {
		return Ward;
	}
	public void setWard(String ward) {
		Ward = ward;
	}
	public String getWay() {
		return Way;
	}
	public void setWay(String way) {
		Way = way;
	}
	public String getStructure() {
		return Structure;
	}
	public void setStructure(String structure) {
		Structure = structure;
	}
	public int getNumberOfBasement() {
		return NumberOfBasement;
	}
	public void setNumberOfBasement(int numberOfBasement) {
		NumberOfBasement = numberOfBasement;
	}
	public int getFloorArea() {
		return FloorArea;
	}
	public void setFloorArea(int floorArea) {
		FloorArea = floorArea;
	}
	public String getDirection() {
		return Direction;
	}
	public void setDirection(String direction) {
		Direction = direction;
	}
	public String getClass1() {
		return Class1;
	}
	public void setClass1(String class1) {
		Class1 = class1;
	}
	public int getRent() {
		return Rent;
	}
	public void setRent(int rent) {
		Rent = rent;
	}
	public String getDescriptionPrice() {
		return DescriptionPrice;
	}
	public void setDescriptionPrice(String descriptionPrice) {
		DescriptionPrice = descriptionPrice;
	}
	public String getMotocycleFee() {
		return MotocycleFee;
	}
	public void setMotocycleFee(String motocycleFee) {
		MotocycleFee = motocycleFee;
	}
	public String getCarFee() {
		return CarFee;
	}
	public void setCarFee(String carFee) {
		CarFee = carFee;
	}
	public String getServiceFee() {
		return ServiceFee;
	}
	public void setServiceFee(String serviceFee) {
		ServiceFee = serviceFee;
	}
	public String getOverTimeFee() {
		return OverTimeFee;
	}
	public void setOverTimeFee(String overTimeFee) {
		OverTimeFee = overTimeFee;
	}
	public String getElectricityBill() {
		return ElectricityBill;
	}
	public void setElectricityBill(String electricityBill) {
		ElectricityBill = electricityBill;
	}
	public int getDeposit() {
		return Deposit;
	}
	public void setDeposit(int deposit) {
		Deposit = deposit;
	}
	public String getPay() {
		return Pay;
	}
	public void setPay(String pay) {
		Pay = pay;
	}
	public String getLeaseTerm() {
		return LeaseTerm;
	}
	public void setLeaseTerm(String leaseTerm) {
		LeaseTerm = leaseTerm;
	}
	public String getDecorationTime() {
		return DecorationTime;
	}
	public void setDecorationTime(String decorationTime) {
		DecorationTime = decorationTime;
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
	public String getBrokerageFee() {
		return BrokerageFee;
	}
	public void setBrokerageFee(String brokerageFee) {
		BrokerageFee = brokerageFee;
	}
	public String getNote() {
		return Note;
	}
	public void setNote(String note) {
		Note = note;
	}
	public DistrictEntity getDistrict() {
		return District;
	}
	public void setDistrict(DistrictEntity district) {
		District = district;
	}
	
}

