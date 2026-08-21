package com.BuildingWeb.DTO.request;

import java.util.List;

public class RequestBuildingUserDTO {
    private Long idBuilding ;
    private List<Long> idUser;

    public Long getIdBuilding() {
        return idBuilding;
    }

    public void setIdBuilding(Long idBuilding) {
        this.idBuilding = idBuilding;
    }

    public List<Long> getIdUser() {
        return idUser;
    }

    public void setIdUser(List<Long> idUser) {
        this.idUser = idUser;
    }
}
