package com.BuildingWeb.DTO;

import lombok.Data;

import java.util.List;

@Data
public class AssigmentCustomerDTO {

    private List<Long> idUser;
    private Long idCustomer;
}
