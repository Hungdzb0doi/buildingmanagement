package com.BuildingWeb.DTO.response;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class TransactionTypeDTO {

    private String code;
    private String transactionTypeName;
}
