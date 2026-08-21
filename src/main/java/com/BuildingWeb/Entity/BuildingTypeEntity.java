package com.BuildingWeb.Entity;

import jakarta.persistence.*;
@Entity
@Table(name="buildingtype")
public class BuildingTypeEntity {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="IdBuildingType")
private Integer idBuildingType;
@Column(name="Code")
private String code;
@Column(name="BuildingTypeName")
private String buildingTypeName;
@Column(name="Note")
private String note;
@ManyToOne
@JoinColumn(name="IdBuilding")
private BuildingEntity building;

    public Integer getIdBuildingType() {
        return idBuildingType;
    }

    public void setIdBuildingType(Integer idBuildingType) {
        this.idBuildingType = idBuildingType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBuildingTypeName() {
        return buildingTypeName;
    }

    public void setBuildingTypeName(String buildingTypeName) {
        this.buildingTypeName = buildingTypeName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public BuildingEntity getBuilding() {
        return building;
    }

    public void setBuilding(BuildingEntity building) {
        this.building = building;
    }
}


