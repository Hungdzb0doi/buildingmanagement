package com.BuildingWeb.DTO.request;

import lombok.Data;

import java.util.List;


@Data
public class RequestTransactionDTO {


    String note;
    Long idCustomer;
    List<String> code;
}
