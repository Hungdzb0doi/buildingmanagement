package com.BuildingWeb.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="district")
public class DistrictEntity {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="IdDistrict")
private Long IdDistrict;
@Column(name="CodeDistrict")
private String CodeDistrict;
@Column(name="DistrictName")
private String DistrictName;
@OneToMany(mappedBy="District",fetch=FetchType.LAZY)
private List<BuildingEntity> Building =new ArrayList<>();

public List<BuildingEntity> getBuilding() {
	return Building;
}
public void setBuilding(List<BuildingEntity> building) {
	Building = building;
}
public Long getIdDistrict() {
	return IdDistrict;
}
public void setIdDistrict(Long i) {
	IdDistrict = i;
}
public String getCodeDistrict() {
	return CodeDistrict;
}
public void setCodeDistrict(String codeDistrict) {
	CodeDistrict = codeDistrict;
}
public String getDistrictName() {
	return DistrictName;
}
public void setDistrictName(String districtName) {
	DistrictName = districtName;
}
}
