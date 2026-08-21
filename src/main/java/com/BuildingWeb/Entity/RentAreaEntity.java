package com.BuildingWeb.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="rentarea")
public class RentAreaEntity {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="IdRentArea")
private Integer idRentArea;
@Column(name="Area")
private Integer area;
@ManyToOne
@JoinColumn(name="IdBuilding")
private BuildingEntity building;

    public Integer getIdRentArea() {
        return idRentArea;
    }

    public void setIdRentArea(Integer idRentArea) {
        this.idRentArea = idRentArea;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public BuildingEntity getBuilding() {
        return building;
    }

    public void setBuilding(BuildingEntity building) {
        this.building = building;
    }


}

