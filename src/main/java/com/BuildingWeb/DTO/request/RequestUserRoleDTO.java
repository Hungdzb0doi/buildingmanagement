package com.BuildingWeb.DTO.request;

import lombok.Data;

import java.util.List;
@Data
public class RequestUserRoleDTO {
    Long idUser;
    List<Long> idRole;

}
