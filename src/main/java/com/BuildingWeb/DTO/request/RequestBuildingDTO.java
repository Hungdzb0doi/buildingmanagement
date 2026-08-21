package com.BuildingWeb.DTO.request;

import java.util.List;

public class RequestBuildingDTO {


    private Long idBuilding;
    private String code;
    private String buildingName;
    private Integer idDistrict;
    private String ward;
    private String way;
    private String structure;
    private Integer numberOfBasement;
    private Integer floorArea;
    private String direction;
    private String class1;
    private String rentArea;
    private Integer emptyArea;
    private Integer rent;
    private String descriptionPrice;
    private String serviceFee;
    private String overTimeFee;
    private String motocycleFee;
    private String carFee;
    private String electricityBill;
    private Integer deposit;
    private String pay;
    private String leaseTerm;
    private String decorationTime;
    private String brokerageFee;
    private String managerName;
    private String managerPhone;
    private String note;


    private List<String> typeCode;



    public Long getIdBuilding() { return idBuilding; }
    public void setIdBuilding(Long idBuilding) { this.idBuilding = idBuilding; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getBuildingName() { return buildingName; }
    public void setBuildingName(String buildingName) { this.buildingName = buildingName; }

    public Integer getIdDistrict() { return idDistrict; }
    public void setIdDistrict(Integer idDistrict) { this.idDistrict = idDistrict; }

    public String getWard() { return ward; }
    public void setWard(String ward) { this.ward = ward; }

    public String getWay() { return way; }
    public void setWay(String way) { this.way = way; }

    public String getStructure() { return structure; }
    public void setStructure(String structure) { this.structure = structure; }

    public Integer getNumberOfBasement() { return numberOfBasement; }
    public void setNumberOfBasement(Integer numberOfBasement) { this.numberOfBasement = numberOfBasement; }

    public Integer getFloorArea() { return floorArea; }
    public void setFloorArea(Integer floorArea) { this.floorArea = floorArea; }

    public String getDirection() { return direction; }
    public void setDirection(String direction) { this.direction = direction; }

    public String getClass1() { return class1; }
    public void setClass1(String class1) { this.class1 = class1; }

    public String getRentArea() { return rentArea; }
    public void setRentArea(String rentArea) { this.rentArea = rentArea; }

    public Integer getEmptyArea() { return emptyArea; }
    public void setEmptyArea(Integer emptyArea) { this.emptyArea = emptyArea; }

    public Integer getRent() { return rent; }
    public void setRent(Integer rent) { this.rent = rent; }

    public String getDescriptionPrice() { return descriptionPrice; }
    public void setDescriptionPrice(String descriptionPrice) { this.descriptionPrice = descriptionPrice; }

    public String getServiceFee() { return serviceFee; }
    public void setServiceFee(String serviceFee) { this.serviceFee = serviceFee; }

    public String getOverTimeFee() { return overTimeFee; }
    public void setOverTimeFee(String overTimeFee) { this.overTimeFee = overTimeFee; }

    public String getMotocycleFee() { return motocycleFee; }
    public void setMotocycleFee(String motocycleFee) { this.motocycleFee = motocycleFee; }

    public String getCarFee() { return carFee; }
    public void setCarFee(String carFee) { this.carFee = carFee; }

    public String getElectricityBill() { return electricityBill; }
    public void setElectricityBill(String electricityBill) { this.electricityBill = electricityBill; }

    public Integer getDeposit() { return deposit; }
    public void setDeposit(Integer deposit) { this.deposit = deposit; }

    public String getPay() { return pay; }
    public void setPay(String pay) { this.pay = pay; }

    public String getLeaseTerm() { return leaseTerm; }
    public void setLeaseTerm(String leaseTerm) { this.leaseTerm = leaseTerm; }

    public String getDecorationTime() { return decorationTime; }
    public void setDecorationTime(String decorationTime) { this.decorationTime = decorationTime; }

    public String getBrokerageFee() { return brokerageFee; }
    public void setBrokerageFee(String brokerageFee) { this.brokerageFee = brokerageFee; }

    public String getManagerName() { return managerName; }
    public void setManagerName(String managerName) { this.managerName = managerName; }

    public String getManagerPhone() { return managerPhone; }
    public void setManagerPhone(String managerPhone) { this.managerPhone = managerPhone; }

    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }

    public List<String> getTypeCode() { return typeCode; }
    public void setTypeCode(List<String> typeCode) { this.typeCode = typeCode; }
}