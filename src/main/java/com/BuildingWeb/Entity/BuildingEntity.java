package com.BuildingWeb.Entity;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name="building")
public class BuildingEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="IdBuilding")
    private Long idBuilding;

    @Column(name="Code")
    private String code;

    @Column(name="BuildingName")
    private String buildingName;

    @Column(name="Ward")
    private String ward;

    @Column(name="Way")
    private String way;

    @Column(name="Structure")
    private String structure;

    @Column(name="NumberOfBasement")
    private int numberOfBasement;

    @Column(name="FloorArea")
    private int floorArea;

    @Column(name="Direction")
    private String direction;

    @Column(name="Class")
    private String class1;

    @Column(name="Rent")
    private int rent;

    @Column(name="DescriptionPrice")
    private String descriptionPrice;

    @Column(name="MotocycleFee")
    private String motocycleFee;

    @Column(name="CarFee")
    private String carFee;

    @Column(name="ServiceFee")
    private String serviceFee;

    @Column(name="OverTimeFee")
    private String overTimeFee;

    @Column(name="ElectricityBill")
    private String electricityBill;

    @Column(name="Deposit")
    private int deposit;

    @Column(name="Pay")
    private String pay;

    @Column(name="LeaseTerm")
    private String leaseTerm;

    @Column(name="DecorationTime")
    private String decorationTime;

    @Column(name="ManagerName")
    private String managerName;

    @Column(name="ManagerPhone")
    private String managerPhone;

    @Column(name="BrokerageFee")
    private String brokerageFee;

    @Column(name="Note")
    private String note;

    @ManyToOne
    @JoinColumn(name="IdDistrict")
    private DistrictEntity district;

    @OneToMany(mappedBy="building", fetch=FetchType.LAZY)
    private List<RentAreaEntity> rentArea = new ArrayList<>();

    @OneToMany(mappedBy="building", fetch=FetchType.LAZY)
    private List<BuildingUserEntity> buildingUser = new ArrayList<>();

    @OneToMany(mappedBy="building", fetch=FetchType.LAZY)
    private List<BuildingTypeEntity> buildingType = new ArrayList<>();


    public Long getIdBuilding() { return idBuilding; }
    public void setIdBuilding(Long idBuilding) { this.idBuilding = idBuilding; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getBuildingName() { return buildingName; }
    public void setBuildingName(String buildingName) { this.buildingName = buildingName; }

    public String getWard() { return ward; }
    public void setWard(String ward) { this.ward = ward; }

    public String getWay() { return way; }
    public void setWay(String way) { this.way = way; }

    public String getStructure() { return structure; }
    public void setStructure(String structure) { this.structure = structure; }

    public int getNumberOfBasement() { return numberOfBasement; }
    public void setNumberOfBasement(int numberOfBasement) { this.numberOfBasement = numberOfBasement; }

    public int getFloorArea() { return floorArea; }
    public void setFloorArea(int floorArea) { this.floorArea = floorArea; }

    public String getDirection() { return direction; }
    public void setDirection(String direction) { this.direction = direction; }

    public String getClass1() { return class1; }
    public void setClass1(String class1) { this.class1 = class1; }

    public int getRent() { return rent; }
    public void setRent(int rent) { this.rent = rent; }

    public String getDescriptionPrice() { return descriptionPrice; }
    public void setDescriptionPrice(String descriptionPrice) { this.descriptionPrice = descriptionPrice; }

    public String getMotocycleFee() { return motocycleFee; }
    public void setMotocycleFee(String motocycleFee) { this.motocycleFee = motocycleFee; }

    public String getCarFee() { return carFee; }
    public void setCarFee(String carFee) { this.carFee = carFee; }

    public String getServiceFee() { return serviceFee; }
    public void setServiceFee(String serviceFee) { this.serviceFee = serviceFee; }

    public String getOverTimeFee() { return overTimeFee; }
    public void setOverTimeFee(String overTimeFee) { this.overTimeFee = overTimeFee; }

    public String getElectricityBill() { return electricityBill; }
    public void setElectricityBill(String electricityBill) { this.electricityBill = electricityBill; }

    public int getDeposit() { return deposit; }
    public void setDeposit(int deposit) { this.deposit = deposit; }

    public String getPay() { return pay; }
    public void setPay(String pay) { this.pay = pay; }

    public String getLeaseTerm() { return leaseTerm; }
    public void setLeaseTerm(String leaseTerm) { this.leaseTerm = leaseTerm; }

    public String getDecorationTime() { return decorationTime; }
    public void setDecorationTime(String decorationTime) { this.decorationTime = decorationTime; }

    public String getManagerName() { return managerName; }
    public void setManagerName(String managerName) { this.managerName = managerName; }

    public String getManagerPhone() { return managerPhone; }
    public void setManagerPhone(String managerPhone) { this.managerPhone = managerPhone; }

    public String getBrokerageFee() { return brokerageFee; }
    public void setBrokerageFee(String brokerageFee) { this.brokerageFee = brokerageFee; }

    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }

    public DistrictEntity getDistrict() { return district; }
    public void setDistrict(DistrictEntity district) { this.district = district; }

    public List<RentAreaEntity> getRentArea() { return rentArea; }
    public void setRentArea(List<RentAreaEntity> rentArea) { this.rentArea = rentArea; }

    public List<BuildingUserEntity> getBuildingUser() { return buildingUser; }
    public void setBuildingUser(List<BuildingUserEntity> buildingUser) { this.buildingUser = buildingUser; }

    public List<BuildingTypeEntity> getBuildingType() { return buildingType; }
    public void setBuildingType(List<BuildingTypeEntity> buildingType) { this.buildingType = buildingType; }
}
