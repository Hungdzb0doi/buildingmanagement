package com.BuildingWeb.DTO.response;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class TransactionDTO {
   private Long idTransaction;
   private String user;
    private String note;
    private String customer;
    private Date createdDate;
    private List<String> code;
    private List<String> transactionTypeName;
}
