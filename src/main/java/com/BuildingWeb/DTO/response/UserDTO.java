package com.BuildingWeb.DTO.response;

import lombok.Data;

import java.util.List;
@Data
public class UserDTO {
  private   Long  idUser;
  private   String phone;
  private   List<String> roles;
  private   String userName;
}
